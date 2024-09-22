package com.pratik.zipnews.data.request


// Define a data class for the request body
data class NewsRequest(
        val site: String,
        val page: Int
)