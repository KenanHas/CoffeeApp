package com.freeapp.coffeeappwithcompose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.freeapp.coffeeappwithcompose.model.CoffeeItem


@Composable
fun DetailScreen(coffeeItem: CoffeeItem) {

    DetailScreenDesign(coffeeItem)
}

@Composable
fun DetailScreenDesign(coffeeItem: CoffeeItem) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF0C1015))){

        Box(modifier = Modifier
            .padding(20.dp)
            .fillMaxHeight(0.5f)){
        ElevatedCard(elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp))
        {
            Box{
            AsyncImage(
                model = coffeeItem.image,
                contentDescription = "${coffeeItem.title}",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize())

                Column(modifier = Modifier.align(Alignment.BottomStart)) {
                    ElevatedCard(modifier = Modifier
                        .height(40.dp)
                        .alpha(0.8f)
                        .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFd49864)),
                        elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp),
                     )
                    {
                        Text(modifier = Modifier
                            .wrapContentHeight(align = Alignment.CenterVertically)
                            .padding(start = 20.dp),
                            text = "${coffeeItem.title}",
                            fontSize = 25.sp,
                            color = Color(0xfffffdd0))
                    }
                }
            }
        }
    }
        Column(modifier = Modifier.padding(horizontal =20.dp)) {
            Text(text = "Description",color = Color(0xFFE16B47), modifier = Modifier.padding(5.dp))
            Divider(color = Color.White, thickness = 0.5.dp)
            Text(text = "${coffeeItem.description}",color = Color.White,modifier = Modifier.padding(5.dp))

            Text(text = "Ingredients",color = Color(0xFFE16B47), modifier = Modifier.padding(5.dp))
            Divider(color = Color.White, thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(2.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(2.dp)){
                items(items = coffeeItem.ingredients){
                    Text(text = it,
                        modifier = Modifier.padding(start=5.dp),
                        color = Color.White)
                }
        }
    }
}
}