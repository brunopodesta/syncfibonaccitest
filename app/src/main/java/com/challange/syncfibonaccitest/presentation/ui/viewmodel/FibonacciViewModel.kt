package com.challange.syncfibonaccitest.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challange.syncfibonaccitest.domain.DeleteLogsUseCase
import com.challange.syncfibonaccitest.domain.GetFibonacciLogUseCase
import com.challange.syncfibonaccitest.domain.GetFibonacciNumberUseCase
import com.challange.syncfibonaccitest.domain.SaveFibonacciNumberUseCase
import com.challange.syncfibonaccitest.domain.model.Fibonacci
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FibonacciViewModel @Inject constructor(
    private val getFibonacciNumberUseCase: GetFibonacciNumberUseCase,
    private val getFibonacciLogUseCase: GetFibonacciLogUseCase,
    private val saveFibonacciNumberUseCase: SaveFibonacciNumberUseCase,
    private val deleteLogsUseCase: DeleteLogsUseCase
) : ViewModel() {

    private var _numbeList = MutableLiveData<List<Fibonacci>>()
    val numberList : LiveData<List<Fibonacci>> get() = _numbeList

    private var _numberSelected = MutableLiveData<Fibonacci>()
    val numberSelected : LiveData<Fibonacci> get() = _numberSelected


    fun getLogs() {
        viewModelScope.launch {
            val register = getFibonacciLogUseCase()
            _numbeList.postValue(register)

        }
    }

    fun getFibonacciNumber() {
        getLogs()
        val result = getFibonacciNumberUseCase()
        val fibonacci = Fibonacci(result, System.currentTimeMillis())
        _numberSelected.value = fibonacci

        saveFibonacciNumber()
    }

    private fun saveFibonacciNumber() {
        viewModelScope.launch {
            saveFibonacciNumberUseCase.saveFibonnaciNumber(numberSelected.value!!)
        }
    }

    fun deleteLogs() {
        viewModelScope.launch {
            deleteLogsUseCase()
            getLogs()
        }

    }
}