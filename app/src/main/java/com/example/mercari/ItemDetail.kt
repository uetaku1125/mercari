package com.example.mercari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class ItemDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val message = intent.getStringExtra(SEARCH_WORDS)
        val textview = findViewById<TextView>(R.id.textView_itemDetail)
        textview.text = message

        val btnBack = findViewById<Button>(R.id.btn_back3)

        btnBack.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //create Intent class object
                val intent = Intent(this@ItemDetail, SearchResult::class.java)

                startActivity(intent)
            }
        })
    }
}