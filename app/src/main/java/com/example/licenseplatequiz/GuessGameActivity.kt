package com.example.licenseplatequiz

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_guess_game.guessEditText
import kotlinx.android.synthetic.main.activity_guess_game.randomNumbersTextView
import kotlinx.android.synthetic.main.activity_guess_game.submitGuessButton
import kotlin.random.Random



class GuessGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_game)

        // Generate random numbers and display them
        val randomNumbers = generateRandomNumbers()
        randomNumbersTextView.text = randomNumbers

        toggleVisibility(View.INVISIBLE)

        // Blur the numbers after 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            blurNumbers()
            toggleVisibility(View.VISIBLE)

        }, 3000)

        // TODO: Implement logic for checking user's guess
        submitGuessButton.setOnClickListener {
            // Get the user's guess from the EditText
            val userGuess = guessEditText.text.toString()
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
        randomNumbersTextView.text = "Blurred"
    }

    private fun toggleVisibility(visibility: Int) {
        guessEditText.visibility = visibility
        submitGuessButton.visibility = visibility
    }
}