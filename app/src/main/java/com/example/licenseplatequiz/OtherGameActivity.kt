package com.example.licenseplatequiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.licenseplatequiz.databinding.ActivityOtherGameBinding

class OtherGameActivity : AppCompatActivity() {

    lateinit var binding: ActivityOtherGameBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityOtherGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Display Hello World Text

    }
}