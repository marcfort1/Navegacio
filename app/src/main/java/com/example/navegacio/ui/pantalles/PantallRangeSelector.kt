package com.example.navegacio.ui.pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun PantallaRangeSelector(onGenerarRandomClick: (Int) -> Unit) {
    var minValue by remember { mutableStateOf(1f) }
    var maxValue by remember { mutableStateOf(10f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Selecciona el valor mínim: ${minValue.toInt()}",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Slider(
            value = minValue,
            onValueChange = { minValue = it },
            valueRange = 1f..maxValue,
            steps = 9,
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF8000FF),
                activeTrackColor = Color(0xFF8000FF),
                inactiveTrackColor = Color(0xFFE0BBFF)
            )
        )

        Text(
            text = "Selecciona el valor màxim: ${maxValue.toInt()}",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Slider(
            value = maxValue,
            onValueChange = { maxValue = it },
            valueRange = minValue..100f,
            steps = 99,
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF8000FF),
                activeTrackColor = Color(0xFF8000FF),
                inactiveTrackColor = Color(0xFFE0BBFF)
            )
        )

        Button(
            onClick = {
                val randomValue = Random.nextInt(minValue.toInt(), maxValue.toInt() + 1)
                onGenerarRandomClick(randomValue)
            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(text = "Generar número aleatori")
        }
    }
}
