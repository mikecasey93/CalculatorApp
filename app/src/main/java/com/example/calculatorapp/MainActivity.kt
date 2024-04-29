package com.example.calculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var canAddOperation = false
    private var canAddDeciamal = true

    fun numberInput(view: View) {
        if(view is Button) {
            if(view.text == ".") {
                if(canAddDeciamal) {
                    binding.tvCalculations.append(view.text)
                }
                canAddDeciamal = false
            }
            else {
                binding.tvCalculations.append(view.text)
            }
            canAddOperation = true
        }
    }

    fun operatorInput(view: View) {
        if(view is Button && canAddOperation) {
            binding.tvCalculations.append(view.text)
            canAddOperation = false
            canAddDeciamal = true
        }
    }

    fun allClearAction(view: View) {
        binding.tvCalculations.text = ""
        binding.tvResults.text = ""
    }

    fun backSpaceAction(vie: View) {
        val length = binding.tvCalculations.length()
        if(length > 0) {
            binding.tvCalculations.text = binding.tvCalculations.text.subSequence(0, length - 1)
        }
    }

    fun equalsAction(view: View) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}