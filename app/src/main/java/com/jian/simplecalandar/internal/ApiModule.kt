package com.jian.simplecalandar.internal

import android.content.Context
import com.google.gson.GsonBuilder
import com.jian.simplecalandar.api.Api
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Named
import javax.inject.Singleton


@Module
class ApiModule {

    private lateinit var api: Api

    @Provides
    fun api(client: OkHttpClient?): Api {
        api = Retrofit.Builder()
            .client(client)
            .baseUrl("https://api.thedogapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build().create(Api::class.java)
        return api
    }

    @Provides
    @Singleton
    fun getClient(cache: Cache): OkHttpClient {
        val builder = OkHttpClient.Builder()
        return builder
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    fun providesCache(@Named("app") context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MB
        return Cache(File(context.cacheDir, "cache_responses"), cacheSize.toLong())
    }
}