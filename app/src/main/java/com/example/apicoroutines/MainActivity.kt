package com.example.apicoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    val quoteApi=RetrofitHelper.getInstance().create(ApiInterFace::class.java)

    GlobalScope.launch {
        val result=quoteApi.getData(2)
        if (result != null){
            val quoteList=result.body()
            GlobalScope.launch (Dispatchers.Main){
                val setAdapter=Adapter(quoteList?.results as ArrayList<QuoteList.Result>)
                binding.recyclerView.layoutManager=LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
                binding.recyclerView.adapter=setAdapter

               /* quoteList?.results?.forEach {
                Log.d("DataPass",it.author)
                    val user=ArrayList<QuoteList>()
                    val setAdapter=Adapter(user)
                    binding.recyclerView.layoutManager=LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
                    binding.recyclerView.adapter=setAdapter
                }*/
            }
        }
    }

    }
}