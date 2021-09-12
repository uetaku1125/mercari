package com.example.mercari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.mercari.MESSAGE"

class RegAddress : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_address)
    }

    fun sendMessage(view: View){
        val editText = findViewById<EditText>(R.id.editTextTextFamilyName)
        val message = editText.text.toString()
        val intent = Intent(this, AddressList::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}