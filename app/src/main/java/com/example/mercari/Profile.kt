package com.example.mercari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnAddress = findViewById<Button>(R.id.btn_address)
        val btnBack = findViewById<Button>(R.id.btn_back)

        btnAddress.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //create Intent class object
                val intent = Intent(this@Profile, AddressList::class.java)

                startActivity(intent)
            }
        })

        btnBack.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //create Intent class object
                val intent = Intent(this@Profile, MyPage::class.java)

                startActivity(intent)
            }
        })
    }
}