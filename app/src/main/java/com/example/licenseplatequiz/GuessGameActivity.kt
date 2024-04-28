package com.example.licenseplatequiz

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.licenseplatequiz.databinding.ActivityGuessGameBinding
import kotlin.random.Random



class GuessGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuessGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuessGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Generate random numbers and display them
        val randomNumbers = generateRandomNumbers()
        binding.randomNumbersTextView.text = randomNumbers

        toggleVisibility(View.INVISIBLE)

        // Blur the numbers after 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            blurNumbers()
            toggleVisibility(View.VISIBLE)

        }, 3000)

        // TODO: Implement logic for checking user's guess
        binding.submitGuessButton.setOnClickListener {
            // Get the user's guess from the EditText
            val userGuess = binding.guessEditText.text.toString()
            // Compare the user's guess with the original numbers
            // Display result to the user
        }
    }

    private fun generateRandomNumbers(): String {
        // Generate a random string of 7 digits
        return (1..7).map { Random.nextInt(0, 10) }.joinToString("")
    }

    private fun blurNumbers() {
        // Blur or hide the numbers to prevent user from seeing them
        binding.randomNumbersTextView.text = "Blurred"
    }

    private fun toggleVisibility(visibility: Int) {
        binding.guessEditText.visibility = visibility
        binding.submitGuessButton.visibility = visibility
    }
}