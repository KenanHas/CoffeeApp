package com.freeapp.coffeeappwithcompose.repository

import com.freeapp.coffeeappwithcompose.apiservice.CoffeeService
import com.freeapp.coffeeappwithcompose.model.CoffeeItem
import retrofit2.Response
import javax.inject.Inject

class CoffeeRepository @Inject constructor(var coffeeService: CoffeeService) {

    suspend fun getHotCoffee():Response<List<CoffeeItem>>{
        return coffeeService.getHotCoffee()
    }

    suspend fun getIcedCoffee(): Response<List<CoffeeItem>>{
        return coffeeService.getIcedCoffee()
    }
}