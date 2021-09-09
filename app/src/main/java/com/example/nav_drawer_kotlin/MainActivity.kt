package com.example.nav_drawer_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.nav_drawer_kotlin.databinding.ActivityMainBinding
import com.example.nav_drawer_kotlin.databinding.NavDrawerBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
   // lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
     //   binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val drawerLayout=findViewById<DrawerLayout>(R.id.drawerLayout_id)
       val imgMenu=findViewById<ImageView>(R.id.imgMenu)

       val navView=findViewById<NavigationView>(R.id.navDrawer_id)
       navView.itemIconTintList=null

       imgMenu.setOnClickListener {
           drawerLayout.openDrawer(GravityCompat.START)
       }

        val navController= Navigation.findNavController(this,R.id.fragment)
        NavigationUI.setupWithNavController(navView,navController)

       val textTitle=findViewById<TextView>(R.id.title)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            textTitle.text = destination.label
        }

    }
}