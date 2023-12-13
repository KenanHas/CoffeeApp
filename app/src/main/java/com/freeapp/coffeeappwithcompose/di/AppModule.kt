package com.freeapp.coffeeappwithcompose.di

import com.freeapp.coffeeappwithcompose.apiservice.CoffeeService
import com.freeapp.coffeeappwithcompose.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesBaseUrl():String{
        return Constants.BASE_URL
    }


    @Provides
    @Singleton
    fun providesRetrofitBuilder(baseUrl:String) : Retrofit{
        var retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun providesCoffeeService(retrofit:Retrofit): CoffeeService{
       return retrofit.create(CoffeeService::class.java)
    }
}