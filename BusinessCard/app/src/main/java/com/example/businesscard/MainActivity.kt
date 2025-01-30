package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) { }
            }
        }
    }
}

@Composable
fun BottomLayout() {
    Column(
        Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactInfoCard(
            iconVector = Icons.Outlined.Phone, contactText = "+00 (00) 00000"
        )
        ContactInfoCard(
            iconVector = Icons.Outlined.Share, contactText = "@AndroidDev"
        )
        ContactInfoCard(
            iconVector = Icons.Outlined.Email, contactText = "joe.bind@android.com"
        )
    }
}

@Composable
fun ContactInfoCard(iconVector: ImageVector, contactText: String, modifier: Modifier = Modifier) {
    Row(
        Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = iconVector, contentDescription = null,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = contactText,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BottomLayout()
    }
}