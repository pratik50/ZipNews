package com.pratik.zipnews.di

import android.content.Context
import com.pratik.zipnews.ZipNews
import com.pratik.zipnews.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewtorkModule {

    @Provides
    @Singleton
    fun providApplication(@ApplicationContext context: Context): ZipNews{
        return context as ZipNews
    }

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context{
        return  context
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttp(): OkHttpClient{
        return OkHttpClient().newBuilder()
            .readTimeout(30L, java.util.concurrent.TimeUnit.SECONDS)
            .writeTimeout(0L, java.util.concurrent.TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): ZipNews{
        return retrofit.create(ZipNews::class.java)
    }
}