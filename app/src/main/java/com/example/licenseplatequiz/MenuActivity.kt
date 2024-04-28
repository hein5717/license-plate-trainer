package com.example.licenseplatequiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.guessGameButton
import kotlinx.android.synthetic.main.activity_menu.otherGameButton


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        guessGameButton.setOnClickListener {
            startActivity(Intent(this, GuessGameActivity::class.java))
        }

        // Add click listener for other game button
        otherGameButton.setOnClickListener {
            // Start other game activity
            startActivity(Intent(this, OtherGameActivity::class.java))
        }
    }
}