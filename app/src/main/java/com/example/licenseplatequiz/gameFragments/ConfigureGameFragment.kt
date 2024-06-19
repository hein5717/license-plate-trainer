package com.example.licenseplatequiz.gameFragments

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.licenseplatequiz.databinding.ActivityConfigureGameBinding

class ConfigureGameFragment: Fragment() {

    private lateinit var binding: ActivityConfigureGameBinding

    private var charsetSelection = "both"
    private var mirroredSelection: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityConfigureGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.numberGames.minValue = 1
        binding.numberGames.maxValue = 99

        binding.numberTime.minValue = 1
        binding.numberTime.maxValue = 60

        binding.numberDigits.minValue = 1
        binding.numberDigits.maxValue = 20

        //TODO: Clean this up. Make it DRY
        configureCharsetSpinner()
        configureMirroredSpinner()

        binding.startGameButton.setOnClickListener {
            var gameSettings = Bundle()
            gameSettings.putBoolean("mirroredSelection", mirroredSelection)
            gameSettings.putString("charsetSelection", charsetSelection)
            gameSettings.putInt("numberOfGames", binding.numberGames.value)
            gameSettings.putInt("timeToGuess", binding.numberTime.value)
            gameSettings.putInt("numberOfDigits", binding.numberDigits.value)

            findNavController().navigate(requireArguments().getInt("selectedGame"), gameSettings)
        }
    }

    fun configureCharsetSpinner() {
        // Clean this up and add another spinner for mirrored
        val textOptions = arrayOf("both", "letters", "numbers")
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, textOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.charsetSelection.adapter = adapter

        binding.charsetSelection.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedOption = textOptions[position]
                // Handle selected option
                charsetSelection = selectedOption
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle case where no option is selected if needed
                charsetSelection = "both"
            }
        }
    }

    fun configureMirroredSpinner() {
        // Clean this up and add another spinner for mirrored
        val textOptions = arrayOf("No", "Yes")
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, textOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.mirrorTextSelection.adapter = adapter

        binding.mirrorTextSelection.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedOption = textOptions[position]
                // Handle selected option
                mirroredSelection = selectedOption == "Yes"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle case where no option is selected if needed
                mirroredSelection = false
            }
        }
    }
}