package com.pratik.zipnews.data.model

data class News(
    val date: String,
    val images: List<Any>,
    val short_description: String,
    val text: String,
    val title: String,
    val top_image: String,
    val url: String,
    val videos: List<Any>
)