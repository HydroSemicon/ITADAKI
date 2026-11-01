package io.github.hydrosemicon.food.data.demo

import io.github.hydrosemicon.food.R
import io.github.hydrosemicon.food.model.Restaurant

object DemoRestaurants {
    val restaurants: List<Restaurant> = listOf(
        Restaurant(
            id = "demo-cafe",
            nameRes = R.string.demo_cafe_name,
            descriptionRes = R.string.demo_cafe_description,
        ),
        Restaurant(
            id = "demo-diner",
            nameRes = R.string.demo_diner_name,
            descriptionRes = R.string.demo_diner_description,
        ),
    )
}
