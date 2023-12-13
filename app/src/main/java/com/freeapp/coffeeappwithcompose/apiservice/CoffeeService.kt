package com.freeapp.coffeeappwithcompose.apiservice

import com.freeapp.coffeeappwithcompose.model.CoffeeItem
import retrofit2.Response
import retrofit2.http.GET

interface CoffeeService {

    @GET("coffee/hot")
    suspend fun getHotCoffee():Response<List<CoffeeItem>>

    @GET("coffee/iced")
    suspend fun getIcedCoffee():Response<List<CoffeeItem>>

}