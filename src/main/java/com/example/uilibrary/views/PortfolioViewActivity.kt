package com.example.uilibrary.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.entities.Portfolio
import kotlinx.coroutines.flow.Flow
@Composable
fun PortfolioValue(portfolioFlow: Flow<Portfolio>) {
    val portfolio by portfolioFlow.collectAsState(initial = Portfolio(userId = "user123",
        portfolioValue = 00.00,
        currency = "___",
        increment = 0.00,
        rate = 0.00))

    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            val formattedValue = String.format("%.2f", portfolio.portfolioValue)
            Text(
                text = formattedValue,
                style = MaterialTheme.typography.headlineLarge.copy(color = Color(0xFF8636a4))
            )
            Row(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "${portfolio.currency}",
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color(0xFF8636a4))
                )
            }
        }
    }
}

@Composable
fun PortfolioRate(portfolioFlow: Flow<Portfolio>) {
    val portfolio by portfolioFlow.collectAsState(initial = Portfolio(userId = "user123",
        portfolioValue = 15000.0,
        currency = "USD",
        increment = 2.50,
        rate = 1.25))

    Surface(
        color = MaterialTheme.colorScheme.secondaryContainer,
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = "  +${portfolio.increment}  (${portfolio.rate})",
            style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFF8636a4))
        )
    }
}

@Composable
fun PortfolioView(portfolioFlow: Flow<Portfolio>) {
    val portfolio by portfolioFlow.collectAsState(initial = Portfolio(userId = "user123",
        portfolioValue = 15000.0,
        currency = "USD",
        increment = 2.50,
        rate = 1.25))

    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.secondaryContainer,
        modifier = Modifier
            .padding(10.dp)
            .height(200.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = "Portfolio value",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color(0xFF8636a4))
            )
            PortfolioValue(portfolioFlow = portfolioFlow)
            PortfolioRate(portfolioFlow = portfolioFlow)
        }
    }
}