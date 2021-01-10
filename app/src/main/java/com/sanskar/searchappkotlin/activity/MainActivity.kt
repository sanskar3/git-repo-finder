package com.sanskar.searchappkotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.sanskar.searchappkotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.search_button)
        val editText1 = findViewById<EditText>(R.id.search_box)

        button1.setOnClickListener(View.OnClickListener {

            val search = editText1.text.toString()

            val intent = Intent(this, SearchListActivity::class.java)
            intent.putExtra("keyName", search)
            startActivity(intent)


        })
    }
}