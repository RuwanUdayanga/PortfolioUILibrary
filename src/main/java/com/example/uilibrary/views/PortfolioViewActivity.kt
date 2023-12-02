package com.example.uilibrary.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.entities.Portfolio

@Composable
fun PortfolioValue(portfolio: Portfolio){
    Surface (
        modifier = Modifier
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "${portfolio.portfolioValue}",
                style = MaterialTheme.typography.headlineLarge.copy(color = Color(0xFF8636a4))

            )
            Row(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "${portfolio.currency}", style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF8636a4)))
            }
        }
    }
}

@Composable
fun PortfolioRate(portfolio: Portfolio){
    Surface ( modifier = Modifier
        .padding(5.dp)){
        Text(text = "+${portfolio.rate}")
    }
}
@Composable
fun PortfolioView(portfolio: Portfolio) {
    Surface(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Column (
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = "Portfolio value",
                style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF8636a4))
            )
            PortfolioValue(portfolio = portfolio)
            PortfolioRate(portfolio = portfolio)
        }
    }
}

//class PortfolioViewActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PortfolioComponentTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier
//                        .padding(10.dp)
//                ) {
//                    Column (
//                        modifier = Modifier
//                            .padding(20.dp)
//                    ) {
//                        Text(
//                            text = "Portfolio value",
//                            style = MaterialTheme.typography.bodySmall
//                        )
//                        val user = Portfolio(userId = "123", portfolioValue = 1000.00 , currency = "AED", rate = 1.20)
//
//                        PortfolioView(user)
//                    }
//                }
//            }
//        }
//    }
//}