package com.example.mercari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button

class SearchResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)



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