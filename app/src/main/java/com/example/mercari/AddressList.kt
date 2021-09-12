package com.example.mercari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class AddressList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_list)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView_address).apply {
            text = message
        }

        val btnRegAddress = findViewById<Button>(R.id.btn_regAddr)
        val btnBackProfile = findViewById<Button>(R.id.btn_backProfile)

        btnRegAddress.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //create Intent class object
                val intent = Intent(this@AddressList, RegAddress::class.java)

                startActivity(intent)
            }
        })

        btnBackProfile.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //create Intent class object
                val intent = Intent(this@AddressList, Profile::class.java)

                startActivity(intent)
            }
        })
    }
}