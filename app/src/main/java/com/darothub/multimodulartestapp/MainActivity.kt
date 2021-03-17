package com.darothub.multimodulartestapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import com.darothub.navigation.Navigator

class MainActivity() : AppCompatActivity(), Navigator {
    override lateinit var navHostFragment: NavHostFragment
    override lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.fragment)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

    }

    override fun goto(destination: Int) {
        //Using fragmentId
        navController.navigate(destination)

    }

    override fun goto(uri: Uri) {
        //Using uri directly
        navController.navigate(uri)
        //or using NavDeepLinkRequest
        val request = NavDeepLinkRequest.Builder
            .fromUri(uri)
            .build()
        navController.navigate(request)

    }

    override fun graphSpecificNavigation(graphId: Int) {
        val myNavHostFragment: NavHostFragment = navHostFragment
        val inflater = myNavHostFragment.navController.navInflater
        val graph = inflater.inflate(graphId)
        navController.graph.addAll(graph)
    }


}

