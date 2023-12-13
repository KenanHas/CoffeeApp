package com.freeapp.coffeeappwithcompose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.freeapp.coffeeappwithcompose.model.CoffeeItem
import com.freeapp.coffeeappwithcompose.viewmodel.CoffeeListViewModel

@Composable
fun HomeScreen(navController: NavController,
               viewModel:CoffeeListViewModel = hiltViewModel()
) {

    val hotCoffeeList = remember { viewModel.hotCoffeeList}
    val icedCoffeeList = remember { viewModel.icedCoffeeList}

    Column(modifier= Modifier
        .background(Color(0xFF0C1015))
        .fillMaxSize()) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Hot Coffee List",
            modifier = Modifier.padding(start = 10.dp,bottom = 5.dp),
            fontSize = 20.sp,
            color = Color(0xFFE16B47))
        CoffeeListView(coffeeList = hotCoffeeList.value,navController)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Iced Coffee List",
            modifier = Modifier.padding(start = 10.dp,bottom = 5.dp),
            fontSize = 20.sp,
            color = Color(0xFFE16B47))
        CoffeeListView(coffeeList = icedCoffeeList.value,navController)
    }
}

@Composable
fun CoffeeListView(coffeeList :List<CoffeeItem>,navController: NavController) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(10.dp)){
        items(items = coffeeList){
            CoffeeItemRow(coffeeItem = it,navController)
        }
    }
}

@Composable
fun CoffeeItemRow(coffeeItem: CoffeeItem,navController: NavController){

        ElevatedCard(modifier= Modifier
            .clickable {
                try {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "coffeeItem",
                        coffeeItem
                    )
                    navController.navigate("detail_screen")

                } catch (e: Exception) {
                    println(e.message)
                }
            }
            .height(335.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp), colors = CardDefaults.cardColors(Color(0xFF1D1D1D))
        ) {

            Column (modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally)
            {

                Box{
                    ElevatedCard()
                    {
                        AsyncImage(
                            model = coffeeItem.image,
                            contentDescription = "${coffeeItem.title}",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(175.dp)
                                .height(175.dp))
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "${coffeeItem.title}",
                    fontSize = 20.sp,
                    color = Color(0xFFE16B47))

                Column {
                   Spacer(modifier = Modifier.height(10.dp))

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(3.dp), horizontalAlignment = Alignment.CenterHorizontally){
                        items(items = coffeeItem.ingredients){
                            Text(modifier = Modifier.fillMaxWidth(),
                                text = it,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                color = Color(0xFFB59B9B))
                        }
                    }
                }
            }
       }
    }
