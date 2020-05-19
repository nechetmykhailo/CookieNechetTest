package ua.com.cookienechettest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ua.com.cookienechettest.adapter.RecyclerAllImageAdapter
import ua.com.cookienechettest.model.Sea
import ua.com.cookienechettest.retrofit.MyInterface
import ua.com.cookienechettest.retrofit.RetroClient

class MainActivity : AppCompatActivity(), RecyclerAllImageAdapter.Callback {

    lateinit var recyclerAdapter: RecyclerAllImageAdapter
    var myList: MutableList<Sea>? = mutableListOf<Sea>()
    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerAdapter = RecyclerAllImageAdapter(this, this)

        recyclerViewAllImage.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerAdapter
        }

        for (i in 1..30){
            val myInterface = MyInterface.create().allImage("girl") // тут изменять для бонусного 2 задания

            myInterface?.enqueue(object : Callback<JsonObject> {
                override fun onFailure(call: Call<JsonObject>, t: Throwable) {}

                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    val jsonObject = response.body()

                    myList?.add(Sea(jsonObject?.get("owner")!!.asString, jsonObject?.get("file")!!.asString))
                    count++
                    loadData()
                }
            })
        }

    }

    private fun loadData() {
        if(count<= 2){
            recyclerAdapter.setMovieListItems(myList!!)
            return
        }
    }

    override fun onItemClicked(item: Sea) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("IMAGE", item.image)
        intent.putExtra("AUTHOR", item.tittle)

        startActivity(intent)
    }
}
