package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.Lab2Theme
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    CounterScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }


                }
            }
        }
    }
    @Composable
    fun CounterScreen(modifier: Modifier = Modifier) {

        var count by remember { mutableIntStateOf(0) }
        var step by remember { mutableIntStateOf(1) }
        var reset by remember { mutableIntStateOf(0) }

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo",
                modifier = Modifier.size(120.dp)
            )

            Spacer(
                modifier = Modifier.height(110.dp)
            )

            Text(
            text = count.toString(),
            fontSize = 48.sp
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ){
                Button(
                    onClick = {
                        count -= step
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier.size(
                        width = 120.dp,
                        height = 55.dp
                    )
                ) {
                    Text(
                        text = "-",
                        fontSize = 24.sp
                    )
                }

                Button(
                    onClick = {
                        count += step
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier.size(
                        width = 120.dp,
                        height = 55.dp
                    )
                ) {
                    Text(
                        text = "+",
                        fontSize = 24.sp
                    )
                }
            }
            Spacer(
                modifier = Modifier.height(40.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                Button(
                    onClick = {
                        count = reset
                        step = 1
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier.size(
                        width = 120.dp,
                        height = 55.dp

                    )
                ) {
                    Text(
                        text = "Reset",
                        fontSize = 24.sp
                    )
                }

                Button(
                    onClick = {
                        step = 2
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier.size(
                        width = 120.dp,
                        height = 55.dp
                    )
                ) {
                    Text(
                        text = "Step",
                        fontSize = 24.sp
                    )
                }
            }


    }
}
