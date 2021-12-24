package com.example.mediamonkschallenge.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediamonkschallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingActivity: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingActivity.root)
    }
}
