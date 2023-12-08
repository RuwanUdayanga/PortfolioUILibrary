package com.example.uilibrary

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uilibrary.views.PortfolioRate
import com.example.uilibrary.views.PortfolioValue
import com.example.uilibrary.views.PortfolioView
import data.entities.Portfolio
import kotlinx.coroutines.flow.flow
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class PortfolioUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testPortfolioValue() {
        val portfolio = Portfolio(
            userId = "user123",
            portfolioValue = 15000.00,
            currency = "USD",
            increment = 2.50,
            rate = 1.25
        )

        composeTestRule.setContent {
            PortfolioValue(portfolioFlow = flow { emit(portfolio) })
        }

        composeTestRule.onNodeWithText("15000.00").assertExists()
    }

    @Test
    fun testPortfolioCurrency() {
        val portfolio = Portfolio(
            userId = "user123",
            portfolioValue = 15000.00,
            currency = "USD",
            increment = 2.50,
            rate = 1.25
        )

        composeTestRule.setContent {
            PortfolioValue(portfolioFlow = flow { emit(portfolio) })
        }

        composeTestRule.onNodeWithText("${portfolio.currency}").assertExists()
    }
    @Test
    fun testPortfolioRate() {
        val portfolio = Portfolio(
            userId = "user123",
            portfolioValue = 15000.00,
            currency = "USD",
            increment = 2.50,
            rate = 1.25
        )

        composeTestRule.setContent {
            PortfolioRate(portfolioFlow = flow { emit(portfolio) })
        }

        composeTestRule.onNodeWithText("${portfolio.rate}", substring = true).assertExists()
    }
    @Test
    fun testPortfolioIncrement() {
        val portfolio = Portfolio(
            userId = "user123",
            portfolioValue = 15000.00,
            currency = "USD",
            increment = 2.50,
            rate = 1.25
        )

        composeTestRule.setContent {
            PortfolioRate(portfolioFlow = flow { emit(portfolio) })
        }

        composeTestRule.onNodeWithText("${portfolio.increment}", substring = true).assertExists()
    }
    @Test
    fun testPortfolioView() {
        val portfolio = Portfolio(
            userId = "user123",
            portfolioValue = 15000.00,
            currency = "USD",
            increment = 2.50,
            rate = 1.25
        )

        composeTestRule.setContent {
            PortfolioView(portfolioFlow = flow { emit(portfolio) })
        }
        composeTestRule.onNodeWithText("15000.00").assertExists()
        composeTestRule.onNodeWithText("${portfolio.currency}").assertExists()
        composeTestRule.onNodeWithText("${portfolio.increment}", substring = true).assertExists()
        composeTestRule.onNodeWithText("${portfolio.rate}", substring = true).assertExists()
    }
}
