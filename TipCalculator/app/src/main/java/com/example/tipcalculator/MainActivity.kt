package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipCalculatorTheme {
                TipCalculatorLayout()
            }
        }
    }
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount
    if (roundUp) tip = kotlin.math.ceil(tip)
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun EditNumberField(
    label: String,
    imeAction: ImeAction,
    value: String,
    onValueChange: (String) -> (Unit),
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction
        ),
        modifier = modifier
    )
}

@Composable
fun RoundUpTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> (Unit),
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Round up tip?")
        Switch(
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        )
    }
}

@Composable
fun TipCalculatorLayout(modifier: Modifier = Modifier) {
    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    var tipPercentInput by remember { mutableStateOf("") }
    val tipPercent = tipPercentInput.toDoubleOrNull() ?: 0.0
    var roundUp by remember { mutableStateOf(false) }
    val tipAmount = calculateTip(amount = amount, tipPercent = tipPercent, roundUp = roundUp)
    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                horizontal = 40.dp
            )
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Calculate Tip",
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            label = "Bill Amount",
            value = amountInput,
            imeAction = ImeAction.Next,
            onValueChange = { amountInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        EditNumberField(
            label = "Tip Percentage",
            value = tipPercentInput,
            imeAction = ImeAction.Done,
            onValueChange = { tipPercentInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        RoundUpTipRow(
            roundUp = roundUp,
            onRoundUpChanged = { roundUp = it },
            modifier = modifier
        )
        Text(
            text = "Tip Amount: $tipAmount",
            style = MaterialTheme.typography.displaySmall
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun TipCalPreview() {
    TipCalculatorLayout()
}