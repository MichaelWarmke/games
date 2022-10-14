package com.example.games

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.games.app.game.Game

class WarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.war)

        val game = Game(2)

        val dealButton: Button = findViewById(R.id.deal_button)

        dealButton.setOnClickListener {
            val winner = game.start()

            val winnerTextBox: TextView = findViewById(R.id.winner_text)
            winnerTextBox.text = winner.name
        }
    }
}