package com.test.kotlinflow

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.test.kotlinflow.databinding.ActivityMainBinding
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private val mainAdapter = MainAdapter()

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerLanguages.run {
            setHasFixedSize(true)
            adapter = mainAdapter
        }

//        lifecycleScope.launch {
//            viewModel.getLanguages().collect {
//                mainAdapter.addLanguage(it)
//            }
//        }

            viewModel.languagesData.observe(this){
                mainAdapter.addLanguage(it)
            }

    }
}