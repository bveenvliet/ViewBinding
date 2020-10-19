package com.example.viewbinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setup view binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set click listener
        binding.btnSubmit.setOnClickListener { view ->
            hideKeyboard(view)
            Toast.makeText(
                this,
                "Hello ${binding.etFirstName.text} ${binding.etLastName.text}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun hideKeyboard(view: View?) {
        view?.apply {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}