package com.games.my.funapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.games.my.funapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_fragment1.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Fragment1 : Fragment() {
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_fragment1, container, false)

        navController = NavHostFragment.findNavController(this)
        val bottomNavView = layout.findViewById<BottomNavigationView>(R.id.bottom_nav_menu)
        bottomNavView.setupWithNavController(navController)
        layout.bottom_nav_menu.setOnNavigationItemSelectedListener { item ->
            navController.navigate(item.itemId)
            return@setOnNavigationItemSelectedListener true
        }
        return layout
    }
}
