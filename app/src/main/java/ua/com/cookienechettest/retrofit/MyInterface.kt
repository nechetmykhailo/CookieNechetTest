package ua.com.cookienechettest.retrofit

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ua.com.cookienechettest.model.Sea

interface MyInterface {
    @GET("/json/320/240/{item}/all")
    fun allImage(@Path("item") item:String): Call<JsonObject>?

    companion object {

        var BASE_URL = "https://loremflickr.com/"

        fun create() : MyInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(MyInterface::class.java)

        }
    }
}