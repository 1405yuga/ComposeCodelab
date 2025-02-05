package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun LemonadeApp() {
    LemonWithButtonAndImage()
}

@Composable
fun LemonWithButtonAndImage(modifier: Modifier = Modifier) {
    var tappingCount by remember { mutableIntStateOf(1) }
    val step: Step = when (tappingCount % 6) {
        1 -> Step(
            imageResource = R.drawable.lemon_tree,
            contentDescriptionResource = R.string.lemon_tree,
            textMessageResource = R.string.select_lemon
        )

        2, 3, 4 -> Step(
            imageResource = R.drawable.lemon_squeeze,
            contentDescriptionResource = R.string.lemon,
            textMessageResource = R.string.squeeze_lemon
        )

        5 -> Step(
            imageResource = R.drawable.lemon_drink,
            contentDescriptionResource = R.string.glass_of_lemonade,
            textMessageResource = R.string.lemonade_to_drink
        )

        else -> Step(
            imageResource = R.drawable.lemon_restart,
            contentDescriptionResource = R.string.empty_glass,
            textMessageResource = R.string.start_again
        )

    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { tappingCount++ },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            Image(
                painter = painterResource(step.imageResource),
                contentDescription = stringResource(step.contentDescriptionResource),
                modifier = Modifier.padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(step.textMessageResource),
            fontSize = 16.sp
        )
    }
}