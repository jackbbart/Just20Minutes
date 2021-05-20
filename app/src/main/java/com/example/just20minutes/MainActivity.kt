package com.example.just20minutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toDoButton= findViewById<Button>(R.id.toDoButton)
        toDoButton.setOnClickListener{
            val intent = Intent(this,ToDoList::class.java)
            startActivity(intent)
            finish()
        }
    }
}

