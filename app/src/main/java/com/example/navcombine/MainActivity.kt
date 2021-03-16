package com.example.navcombine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.navcombine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var authState = true //уже авторизован(true) или ещё нет(false)
        setNavigationGraph(authState)
    }

    //программно устанавливаем стартовое View: зависит от авторизации
    private fun setNavigationGraph(auth: Boolean) {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.host_main) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.navigation_app)

        navGraph.startDestination =
            if (auth) {
                R.id.navigation_drawer_bottom
            } else {
                R.id.navigation_login
            }

        navController.graph = navGraph

    }
}