package com.example.mvvmexample02.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewAPIServiceTest {
    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer // ako ne prepoznaje onda mora da se testImplementation 'junit:junit:4.13.2' da ide sa problem a ne sa + (testImplementation 'junit:junit:4+')

    // command + N -> SetUp Function -> JUnit4
    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder().baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(NewsAPIService::class.java)
    }

    // command + N -> TearDown Function -> JUnit4
    @After
    fun tearDown() {
        server.shutdown()
    }

    private fun enqueueMockResponse(
        filaName: String
    ) {
        val inputSteam = javaClass.classLoader!!.getResourceAsStream(filaName)
        val source = inputSteam.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getNewsHeadlines_sentRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getNewsHeadlines(country = "us", page = 1).body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=d2b97b3fd9584d85a6ccea6640cca5d8")
        }
    }

    @Test
    fun getNewsHeadlines_receivedRequest_correctPageSize() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getNewsHeadlines(country = "us", page = 1).body()
            val articlesList = responseBody!!.articles
            assertThat(articlesList.size).isEqualTo(20)
        }
    }

    @Test
    fun getNewsHeadlines_receivedRequest_correctContent() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getNewsHeadlines(country = "us", page = 1).body()
            val articlesList = responseBody!!.articles
            val article = articlesList[0]
            assertThat(article.author).isEqualTo("Brenna White")
        }
    }
}