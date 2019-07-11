package com.games.my.funapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.games.my.funapp.R
import com.games.my.funapp.adapters.LogsAdapter
import com.games.my.funapp.viewmodels.LogViewModel


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
    private lateinit var logViewModel: LogViewModel
    private lateinit var layout: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_fragment1, container, false)
        val recyclerView: RecyclerView = layout.findViewById(R.id.recycle_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        val adapter = LogsAdapter()
        recyclerView.adapter = adapter
        navController = NavHostFragment.findNavController(this)
        logViewModel = ViewModelProviders.of(this).get(LogViewModel::class.java)
        logViewModel.getAllLogs().observe(this, Observer {
            adapter.setLogs(it)
        })
        return layout
    }
}
