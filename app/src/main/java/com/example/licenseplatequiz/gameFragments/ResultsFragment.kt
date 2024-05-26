package com.example.licenseplatequiz.gameFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.licenseplatequiz.databinding.ActivityResultsBinding

class ResultsFragment : Fragment() {

    private lateinit var binding: ActivityResultsBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityResultsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var resultText = "Total Guesses: ${arguments?.getInt("totalGamesPlayed")}\n" +
                "Correct Answers: ${arguments?.getInt("correctCount")}\n"+
                "Incorrect Answers: ${arguments?.getInt("incorrectCount")}"

        binding.resultsDataText.text = resultText


    }
}