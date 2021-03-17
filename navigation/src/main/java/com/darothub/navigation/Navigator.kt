package com.darothub.navigation

import android.app.Activity
import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment


interface Navigator{
    var navHostFragment:NavHostFragment
    var navController:NavController
    fun goto(destination: Int)
    fun goto(uri: Uri)
    fun goto(destination: Int, graphId:Int){
        val myNavHostFragment: NavHostFragment = navHostFragment
        val inflater = myNavHostFragment.navController.navInflater
        val graph = inflater.inflate(graphId)
        myNavHostFragment.navController.graph = graph

        goto(destination)
    }
    fun goto(uri: Uri, graphId:Int){
        val myNavHostFragment: NavHostFragment = navHostFragment
        val inflater = myNavHostFragment.navController.navInflater
        val graph = inflater.inflate(graphId)
        myNavHostFragment.navController.graph = graph
        goto(uri)
    }

    fun graphSpecificNavigation(graphId:Int)
}

