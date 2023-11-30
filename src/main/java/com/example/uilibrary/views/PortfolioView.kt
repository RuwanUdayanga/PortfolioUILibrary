package com.example.mylibrary.views

import androidx.compose.foundation.layout.*

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import data.entities.Portfolio

@Composable

fun PortfolioView(user: Portfolio, portfolioValue: Double) {

    Surface(

        modifier = Modifier

            .padding(8.dp)

            .fillMaxWidth()

    ) {

        Column(

            modifier = Modifier

                .padding(16.dp)

                .fillMaxWidth()

        ) {

            Text(

                text = "User Name: ${user.userId}",

                style = MaterialTheme.typography.titleLarge

            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(

                text = "Portfolio Value: $portfolioValue",

                style = MaterialTheme.typography.bodyMedium

            )

        }

    }

}

@Preview

@Composable

fun PortfolioViewPreview() {

    val user = Portfolio(userId = "123", portfolioValue = 10000.00, currency = "AED", rate = 1.2)

    PortfolioView(user, 10000.0)

}


