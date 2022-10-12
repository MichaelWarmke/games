package com.example.games

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class GamesLandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MAIN", "Main Launched")
    }

    fun war(view: View) {
        Log.i("MAIN","Starting War")
        startActivity(Intent(this, WarActivity::class.java))
    }

    fun idiot(view: View) {
        Log.i("MAIN", "Starting Idiot")
        startActivity(Intent(this, IdiotActivity::class.java))
    }
}