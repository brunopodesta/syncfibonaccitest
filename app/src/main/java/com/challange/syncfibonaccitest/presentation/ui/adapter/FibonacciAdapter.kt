package com.challange.syncfibonaccitest.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.challange.syncfibonaccitest.R
import com.challange.syncfibonaccitest.databinding.ListFibonacciItemBinding
import com.challange.syncfibonaccitest.domain.model.Fibonacci
import java.text.DateFormat
import java.util.*
import kotlin.collections.ArrayList

class FibonacciAdapter() : RecyclerView.Adapter<FibonacciAdapter.ViewHolder>() {

    private var numbersLogs = ArrayList<Fibonacci>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.list_fibonacci_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fibonacci = numbersLogs[position]
        holder.bin(fibonacci)
    }

    override fun getItemCount(): Int {
        return numbersLogs.size
    }

    fun setData(numbers: List<Fibonacci>) {
        numbersLogs.clear()
        numbersLogs.addAll(numbers)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ListFibonacciItemBinding.bind(view)

        fun bin(fibonacci: Fibonacci) {
            binding.apply {
                tvNumber.text = fibonacci.number.toString()

                tvDate.text = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT)
                    .format(Date(fibonacci.saveTime))
            }

        }

    }


}