package com.example.mercari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MyPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val btnProfile = findViewById<Button>(R.id.btn_profile)
        val btnBack = findViewById<Button>(R.id.btn_home)

        btnProfile.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //create Intent class object
                val intent = Intent(this@MyPage, Profile::class.java)

                startActivity(intent)
            }
        })

        btnBack.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //create Intent class object
                val intent = Intent(this@MyPage, MainActivity::class.java)

                startActivity(intent)
            }
        })
    }
}