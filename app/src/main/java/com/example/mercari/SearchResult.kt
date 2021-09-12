package com.example.mercari

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.*
import androidx.annotation.LayoutRes


class SearchResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(SEARCH_WORDS)
        val listView = findViewById<ListView>(R.id.listView)
        val data = arrayOf(message, message, message, message)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            data
        )
        listView.adapter = adapter

        listView.setOnItemClickListener {parent, view, position, id ->
            val item = (view.findViewById<TextView>(android.R.id.text1)).text
//            Toast.makeText(applicationContext, item, Toast.LENGTH_LONG).show()
            val intent = Intent(this@SearchResult, ItemDetail::class.java).apply {
                putExtra(SEARCH_WORDS, message)
            }

            startActivity(intent)

        }

        val btnHome = findViewById<Button>(R.id.btn_home2)

        btnHome.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //create Intent class object
                val intent = Intent(this@SearchResult, MainActivity::class.java)

                startActivity(intent)
            }
        })
    }
}