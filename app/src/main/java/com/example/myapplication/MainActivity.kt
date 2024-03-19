package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var elements: QueueElements
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        elements = QueueElements(binding)
        val n = 6
    }

    fun skip(view: View) {
        var intent = Intent(this, EmptyActivity::class.java)
        startActivity(intent)
        finish()

    }
    fun next(view: View) {
        if(!elements.next()) {
            var intent = Intent(this, EmptyActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}