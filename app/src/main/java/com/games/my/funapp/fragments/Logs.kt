package com.games.my.funapp.fragments


import android.os.Bundle
import android.view.*
import com.games.my.funapp.R
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.games.my.funapp.AppError
import com.games.my.funapp.adapters.LogsAdapter
import com.games.my.funapp.appHelp.AppHelp
import com.games.my.funapp.data.Log
import com.games.my.funapp.viewmodels.LogViewModel
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Logs : Fragment() {
    private lateinit var navController: NavController
    private lateinit var logViewModel: LogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_logs, container, false)
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

        ItemTouchHelper(object: SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                logViewModel.delete(adapter.getLogAt(viewHolder.adapterPosition))
            }

        }).attachToRecyclerView(recyclerView)
        return layout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.log_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.delete_all_logs -> {
                logViewModel.deleteAllLogs()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
