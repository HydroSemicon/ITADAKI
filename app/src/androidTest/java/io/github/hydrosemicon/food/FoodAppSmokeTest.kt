package io.github.hydrosemicon.food

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollToNode
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FoodAppSmokeTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun appLaunchesAndShowsDemoRestaurants() {
        composeRule.onNodeWithText(composeRule.activity.getString(R.string.food_title))
            .assertIsDisplayed()
        listOf(R.string.demo_cafe_name, R.string.demo_diner_name).forEach { nameRes ->
            val restaurantName = composeRule.activity.getString(nameRes)
            composeRule.onNode(hasScrollAction()).performScrollToNode(hasText(restaurantName))
            composeRule.onNodeWithText(restaurantName).assertIsDisplayed()
        }
    }
}
