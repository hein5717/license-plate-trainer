package com.example.licenseplatequiz.gameFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.licenseplatequiz.R
import com.example.licenseplatequiz.databinding.ActivityMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.guessGameButton.setOnClickListener {
            findNavController().navigate(R.id.guessGameFragment)
        }

        binding.otherGameButton.setOnClickListener {
            findNavController().navigate(R.id.otherGameFragment)
        }
    }
}