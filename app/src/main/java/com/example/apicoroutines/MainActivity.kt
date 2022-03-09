package com.example.apicoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quoteApi = RetrofitHelper.getInstance().create(ApiInterFace::class.java)

        lifecycleScope.launch {
            val result = quoteApi.getData(2)
            val quoteList = result.body()
            lifecycleScope.launch(Dispatchers.Main) {
                val setAdapter = Adapter(quoteList?.results as ArrayList<QuoteList.Result>)
                binding.recyclerView.layoutManager =
                    LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                binding.recyclerView.adapter = setAdapter
            }
        }
    }
}