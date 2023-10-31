package com.example.portfolioteenageremotionpreventappexpertandmanager.expertTeenagerStatistics

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

private val mHttpLoggingInterceptor = HttpLoggingInterceptor()
    .setLevel(HttpLoggingInterceptor.Level.BODY) // BASIC) // check constants

//private val mOkHttpClient = OkHttpClient
//    .Builder()
//    .addInterceptor(mHttpLoggingInterceptor)
//    .build()

private val moshi = Moshi.Builder()//더 편하게 하기 위해서 사용
    .add(KotlinJsonAdapterFactory())
    .build()

private fun createRetrofit(baseUrl: String): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(baseUrl)
        .build()
}

interface ExpertTeenagerStatisticsApiService {
    @Headers("Content-Type: application/json")

    @POST("/statistics")
    suspend fun sendsMessage(@Body message: ExpertTeenagerStatisticsData): Response<ExpertTeenagerStatisticsDataResponse>

}


object ExpertTeenagerStatisticsApi {
    fun retrofitService(baseUrl: String): ExpertTeenagerStatisticsApiService {
        val retrofit = createRetrofit(baseUrl)
        return retrofit.create(ExpertTeenagerStatisticsApiService::class.java)
    }
}