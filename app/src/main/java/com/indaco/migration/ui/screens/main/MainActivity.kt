package com.indaco.migration.ui.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.indaco.migration.dagger.DaggerEnum
import com.indaco.migration.databinding.ActivityMainBinding

import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var mainViewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        DaggerEnum.instance.appComponent?.inject(this)

        binding.tvTitle.text = "this is a test"

        binding.innerLayout.innerText.text = "inner test change"
    }
}