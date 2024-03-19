package com.example.myapplication

import android.app.VoiceInteractor.PickOptionRequest.Option
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        val sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("FirstOpening", true).apply();

        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

        Toast.makeText(this,"Opening", Toast.LENGTH_LONG).show()
    }
}