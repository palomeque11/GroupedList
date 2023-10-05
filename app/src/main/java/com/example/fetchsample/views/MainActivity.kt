package com.example.fetchsample.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchsample.databinding.ActivityMainBinding
import com.example.fetchsample.model.domain.Item
import com.example.fetchsample.utils.ResultState
import com.example.fetchsample.views.adapter.ItemAdapter
import com.example.fetchsample.views.viewmodel.MainBaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val viewModel: MainBaseViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
    }


    override fun onStart() {
        super.onStart()
        requestData()
        viewModel.getItemList()
    }

    private fun requestData() {
        viewModel.characters.observe(this) {
            when(it) {
                is ResultState.Loading -> {}
                is ResultState.Success -> {
                    updateAdapter(it.data)
                }
                is ResultState.Error -> {
                    Toast.makeText(this, "${it.error.message}", Toast.LENGTH_SHORT).show()
                    println("${it.error.message}")
                }
                else -> {}
            }
        }
    }

    private fun updateAdapter(dataSet: List<Item>) {
        binding.listResult.layoutManager = LinearLayoutManager(this)
        binding.listResult.adapter = ItemAdapter(dataSet)
    }

}