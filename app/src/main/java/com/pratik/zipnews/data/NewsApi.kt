package com.pratik.zipnews.data

import com.pratik.zipnews.data.request.NewsRequest
import com.pratik.zipnews.data.response.NewsResponse
import com.pratik.zipnews.utils.API_KEY
import retrofit2.http.Body
import retrofit2.http.Headers


interface NewsApi {

    @Headers(
        "x-rapidapi-key: $API_KEY",
        "x-rapidapi-host: newsnow.p.rapidapi.com",
        "Content-Type: application/json"
    )
    suspend fun getNews(@Body request: NewsRequest): NewsResponse
}