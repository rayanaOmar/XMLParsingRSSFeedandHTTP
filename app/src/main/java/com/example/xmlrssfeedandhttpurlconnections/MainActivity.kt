package com.example.xmlrssfeedandhttpurlconnections

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlrssfeedandhttpurlconnections.api.APIClient
import com.example.xmlrssfeedandhttpurlconnections.api.APIInterface
import com.example.xmlrssfeedandhttpurlconnections.model.Entry
import com.example.xmlrssfeedandhttpurlconnections.model.Feed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var mainRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRV = findViewById(R.id.rvMain)
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        apiInterface!!.getArchFeed().enqueue(object : Callback<Feed> {
            override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
                updateRV(response.body()!!.entries)
            }

            override fun onFailure(call: Call<Feed>, t: Throwable) {
                call.cancel()
            }
        })
    }

    fun updateRV(entries: List<Entry>?) {
        mainRV.adapter = RVadapter(entries)
        mainRV.layoutManager = LinearLayoutManager(applicationContext)
    }
}