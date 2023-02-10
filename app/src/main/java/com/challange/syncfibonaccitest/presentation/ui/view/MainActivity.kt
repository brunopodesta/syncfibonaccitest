package com.challange.syncfibonaccitest.presentation.ui.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.challange.syncfibonaccitest.R
import com.challange.syncfibonaccitest.databinding.ActivityMainBinding
import com.challange.syncfibonaccitest.presentation.ui.adapter.FibonacciAdapter
import com.challange.syncfibonaccitest.presentation.ui.viewmodel.FibonacciViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bindig : ActivityMainBinding
    private val fibonacciViewModel : FibonacciViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindig = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        fibonacciViewModel.numberSelected.observe(this) {
            bindig.txvFibNumber.text = it.number.toString()
        }

        val fibonacciAdapter = FibonacciAdapter()

        bindig.rvLogs.apply {
            adapter = fibonacciAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        fibonacciViewModel.numberList.observe(this) { numberList ->
            if (numberList.isNotEmpty()) {
                bindig.lytData.visibility = View.VISIBLE
                bindig.rvLogs.visibility = View.VISIBLE
                fibonacciAdapter.setData(numberList)
            } else {
                bindig.lytData.visibility = View.INVISIBLE
                bindig.rvLogs.visibility = View.INVISIBLE
            }
        }

        bindig.btnFib.setOnClickListener() {
            fibonacciViewModel.getFibonacciNumber()
        }

        fibonacciViewModel.getLogs()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_delete) {
            fibonacciViewModel.deleteLogs()
            bindig.txvFibNumber.text = ""
        }

        return super.onOptionsItemSelected(item)
    }


}