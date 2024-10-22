package com.example.navegacio.ui.pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaCaraCreu(cara: Boolean, onTornarClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = if (cara) Icons.Filled.Face else Icons.Filled.Close,
            contentDescription = if (cara) "Cara" else "Creu",
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )

        Button(
            onClick = { onTornarClick() },
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Text(
                text = "Tornar a la pantalla principal",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
