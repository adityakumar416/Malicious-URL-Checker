package com.example.psylinksassignment

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.psylinksassignment.databinding.ActivityMainBinding
import com.example.psylinksassignment.viewModel.DataViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: DataViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.checkButton.setOnClickListener {
            binding.progress.visibility = View.VISIBLE
            val apiKey = "RrUI8gdP84XetW5111qopgL78bGcNrTo" // Replace with your actual API key from IPQuality Score
            val url = binding.urlEditText.text.toString()
            viewModel.checkUrl(apiKey, url)
        }

        viewModel.myData?.observe(this, Observer { response ->
            binding.progress.visibility = View.GONE

            response?.let {
                binding.resultTextView.text = "Success: ${it.success}"
                binding.serverNameTextView.text = "Server Name: ${it.server}"
                binding.message.text = "Status: ${it.message}"
                binding.Domain.text = "Domain: ${it.domain}"
                binding.Malware.text = "Is Malicious: ${it.malware}"
                binding.RiskScore.text = "Risk Score: ${it.riskScore}"
                binding.DomainCategory.text = "Domain Category: ${it.category}"

                // Handle other fields as needed
            } ?: run {
                binding.resultTextView.text = "Error occurred"
                binding.serverNameTextView.text = ""
                // Handle other UI updates for error state
            }
        })
    }
}