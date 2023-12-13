package com.freeapp.coffeeappwithcompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freeapp.coffeeappwithcompose.model.CoffeeItem
import com.freeapp.coffeeappwithcompose.repository.CoffeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoffeeListViewModel @Inject constructor(var repository: CoffeeRepository) : ViewModel() {

    var hotCoffeeList = mutableStateOf<List<CoffeeItem>>(listOf())
    var icedCoffeeList = mutableStateOf<List<CoffeeItem>>(listOf())

    init {
        getHotCoffee()
        getIcedCoffee()
    }

    fun getHotCoffee(){
        viewModelScope.launch {
          var response = repository.getHotCoffee()
           if (response.isSuccessful){
               hotCoffeeList.value= (response.body()!!)
              // println(response.body()!!)
           }else{
               println("Api doesn't reponse. ${response.errorBody()}")
           }
        }
    }

    fun getIcedCoffee(){
        viewModelScope.launch {
            var response = repository.getIcedCoffee()
            if (response.isSuccessful){
                icedCoffeeList.value= (response.body()!!)
            }else{
                println("Api doesn't reponse. ${response.errorBody()}")
            }
        }
    }
}