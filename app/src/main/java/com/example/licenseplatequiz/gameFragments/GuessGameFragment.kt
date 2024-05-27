package com.example.licenseplatequiz.gameFragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.licenseplatequiz.R
import com.example.licenseplatequiz.databinding.ActivityGuessGameBinding
import kotlin.random.Random


class GuessGameFragment : Fragment() {

    private var numberOfGames: Int = 1
    private var timeToGuess: Int = 1
    private var numberOfDigits: Int = 1

    private var gamesPlayedCount: Int = 0
    private var correctCount: Int = 0
    private var incorrectCount: Int = 0

    private lateinit var binding: ActivityGuessGameBinding
    private lateinit var randomNumbers: String

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

        numberOfGames = requireArguments().getInt("numberOfGames")
        timeToGuess = requireArguments().getInt("timeToGuess")
        numberOfDigits = requireArguments().getInt("numberOfDigits")

        initGame()

        // TODO: Implement logic for checking user's guess
        binding.submitGuessButton.setOnClickListener {
            gamesPlayedCount += 1
            val userGuess = binding.guessEditText.text.toString()
            if (gamesPlayedCount < numberOfGames) {
                // Get the user's guess from the EditText
                // Compare the user's guess with the original numbers
                if (userGuess == randomNumbers) {
                    // Display a success message to the user
                    binding.resultTextView.text = "Correct!"
                    correctCount += 1
                } else {
                    // Display an error message to the user
                    binding.resultTextView.text = "Incorrect"
                    incorrectCount += 1
                }

                toggleGameVisibility(View.INVISIBLE)
                toggleNumberVisibility(mask = false)
                toggleResultVisibility(View.VISIBLE)

                Handler(Looper.getMainLooper()).postDelayed({
                    binding.guessEditText.text.clear()
                    initGame()
                }, 3000)
            } else {
                binding.resultTextView.text = if (userGuess == randomNumbers) "Correct!" else "Incorrect"
                toggleGameVisibility(View.INVISIBLE)
                toggleNumberVisibility(mask = false)
                toggleResultVisibility(View.VISIBLE)


                Handler(Looper.getMainLooper()).postDelayed({
                    binding.resultTextView.text = "Game Over"
                    binding.randomNumbersTextView.visibility = View.INVISIBLE

                    Handler(Looper.getMainLooper()).postDelayed({
                        val args = Bundle()
                        args.putInt("totalGamesPlayed", numberOfGames)
                        args.putInt("correctCount", correctCount)
                        args.putInt("incorrectCount", incorrectCount)

                        findNavController().navigate(R.id.resultsFragment, args)
                    }, 3000)
                }, 3000)
            }
        }
    }

    fun initGame() {
        // Generate random numbers and display them
        randomNumbers = generateRandomNumbers()
        binding.randomNumbersTextView.text = randomNumbers

        toggleResultVisibility(View.INVISIBLE)
        toggleGameVisibility(View.INVISIBLE)

        // Blur the numbers after 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            toggleNumberVisibility(mask = true)
            toggleGameVisibility(View.VISIBLE)

        }, (timeToGuess*1000).toLong())
    }

    private fun generateRandomNumbers(): String {
        // Generate a random string of 7 digits
        return (1..numberOfDigits).map { Random.nextInt(0, 10) }.joinToString("")
    }

    private fun toggleNumberVisibility(mask: Boolean) {
        if (mask) {
            binding.randomNumbersTextView.text = "Blurred"
        } else {
            binding.randomNumbersTextView.text = randomNumbers
        }
    }

    private fun toggleGameVisibility(visibility: Int) {
        binding.guessEditText.visibility = visibility
        binding.submitGuessButton.visibility = visibility
    }

    private fun toggleResultVisibility(visibility: Int) {
        binding.resultTextView.visibility = visibility
    }
}