package com.example.licenseplatequiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.licenseplatequiz.databinding.ActivityMenuBinding


class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.guessGameButton.setOnClickListener {
            startActivity(Intent(this, GuessGameActivity::class.java))
        }

        // Add click listener for other game button
        binding.otherGameButton.setOnClickListener {
            // Start other game activity
            startActivity(Intent(this, OtherGameActivity::class.java))
        }
    }
}