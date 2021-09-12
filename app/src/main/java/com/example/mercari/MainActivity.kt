package com.example.mercari

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView

const val SEARCH_WORDS = "com.example.mercari.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIntent = findViewById<Button>(R.id.btn_mypage)
        //val searchIntent = findViewById<SearchView>(R.id.search)

        btnIntent.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //create Intent class object
                val intent = Intent(this@MainActivity, MyPage::class.java)

                startActivity(intent)
            }
        })

        val searchView = findViewById<SearchView>(R.id.search)
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                // text changed
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                // submit button pressed
                val editText = findViewById<SearchView>(R.id.search)
                val message = editText.query.toString()

                //create Intent class object
                val intent = Intent(this@MainActivity, SearchResult::class.java).apply {
                    putExtra(SEARCH_WORDS, message)
                }

                startActivity(intent)
                return true
            }
        })
    }
}