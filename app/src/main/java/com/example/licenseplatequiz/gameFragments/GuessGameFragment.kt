package com.example.licenseplatequiz.gameFragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.licenseplatequiz.databinding.ActivityGuessGameBinding
import kotlin.random.Random


class GuessGameFragment : Fragment() {

    private lateinit var binding: ActivityGuessGameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityGuessGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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