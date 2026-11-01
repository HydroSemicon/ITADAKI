package io.github.hydrosemicon.food.model

import androidx.annotation.StringRes

// Demo content uses resource IDs. Replace with API-facing models when the data contract is agreed.
data class Restaurant(
    val id: String,
    @param:StringRes val nameRes: Int,
    @param:StringRes val descriptionRes: Int,
)
