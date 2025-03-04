package com.example.replyapp

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.replyapp.ui.ReplyApp
import org.junit.Rule
import org.junit.Test

class ReplyAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun compactDevice_verifyUsingBottomNavigation(){
        composeTestRule.setContent {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }

        composeTestRule.onNodeWithTagForStringId(R.string.navigation_bottom).assertExists()
    }
}