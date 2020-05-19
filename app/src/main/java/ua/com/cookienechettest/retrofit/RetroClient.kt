package ua.com.cookienechettest.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroClient {
    private val httpClient = OkHttpClient.Builder()
    private val retrofitInstance: Retrofit
        get() {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val builder = Retrofit.Builder()
                .baseUrl("https://loremflickr.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
            return builder.client(httpClient.build()).build()
        }

    val apiService: MyInterface
        get() = retrofitInstance.create<MyInterface>(MyInterface::class.java)
}