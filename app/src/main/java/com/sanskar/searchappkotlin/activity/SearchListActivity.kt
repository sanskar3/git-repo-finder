package com.sanskar.searchappkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.sanskar.searchappkotlin.MyAdapter
import com.sanskar.searchappkotlin.api.MySingleton
import com.sanskar.searchappkotlin.R
import com.sanskar.searchappkotlin.model.Item
import kotlinx.android.synthetic.main.activity_search_list.*

class SearchListActivity : AppCompatActivity() {
    private val searchText = intent.getStringExtra("keyName")

    private lateinit var mAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)

        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()
        mAdapter = MyAdapter()
        recyclerView.adapter = mAdapter
    }

    private fun fetchData() {
        val url = "https://api.github.com/search/repositories?sort=stars&order=desc&q=$searchText"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener {
                val jsonArray = it.getJSONArray("items")
                val searchArray = ArrayList<Item>()
                for (i in 0 until jsonArray.length()) {
                    val searchJsonObject = jsonArray.getJSONObject(i)
                    val item = Item(
                        searchJsonObject.getString("name"),
                        searchJsonObject.getString("language"),
                        searchJsonObject.getString("avatar_url"),
                        searchJsonObject.getInt("stargazers_count")
                    )
                    searchArray.add(item)
                }
                mAdapter.updateSearch(searchArray)
            }, Response.ErrorListener { }
        )
        MySingleton.getInstance(this).addTORequestQueue(jsonObjectRequest)
    }
}