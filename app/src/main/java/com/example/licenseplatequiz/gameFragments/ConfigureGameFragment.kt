package com.example.licenseplatequiz.gameFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.licenseplatequiz.databinding.ActivityConfigureGameBinding

class ConfigureGameFragment: Fragment() {

    private lateinit var binding: ActivityConfigureGameBinding


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
        binding.numberDigits.maxValue = 30

        binding.startGameButton.setOnClickListener {
            var gameSettings = Bundle()
            gameSettings.putInt("numberOfGames", binding.numberGames.value)
            gameSettings.putInt("timeToGuess", binding.numberTime.value)
            gameSettings.putInt("numberOfDigits", binding.numberDigits.value)

            findNavController().navigate(requireArguments().getInt("selectedGame"), gameSettings)


        }

    }
}