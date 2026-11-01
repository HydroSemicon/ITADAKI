package io.github.hydrosemicon.food

import androidx.compose.runtime.Composable
import io.github.hydrosemicon.food.data.demo.DemoRestaurants
import io.github.hydrosemicon.food.ui.home.HomeScreen

@Composable
fun FoodApp() {
    HomeScreen(restaurants = DemoRestaurants.restaurants)
}
