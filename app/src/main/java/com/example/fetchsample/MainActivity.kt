package com.example.fetchsample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchsample.databinding.ActivityMainBinding
import com.example.fetchsample.model.ItemList
import com.example.fetchsample.view.ItemAdapter
import com.example.fetchsample.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val viewModel: AppViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
    }


    override fun onStart() {
        super.onStart()
        requestData()

    }

    private fun requestData() {
        viewModel.getItemList().enqueue(object : Callback<List<ItemList>> {
            override fun onResponse(
                call: Call<List<ItemList>>,
                response: Response<List<ItemList>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        updateAdapter(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<ItemList>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something wrong with the api call", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun updateAdapter(dataSet: List<ItemList>) {
        binding.dailyResults.layoutManager = LinearLayoutManager(this)
        binding.dailyResults.adapter = ItemAdapter(dataSet)
    }

}