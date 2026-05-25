package com.example.fruithubapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fruithubapp.R

@Composable
fun WellComeScreen(onNavigateToHome: () -> Unit = {}) {

    Column(Modifier
        .fillMaxSize()
        .background(Color.White)) {

        Box(Modifier
            .fillMaxWidth()
            .weight(0.65f)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF8C42), Color(0xFFFF7A2B)
                    )
                )
            ),
            contentAlignment = Alignment.Center
            ){

            Box(Modifier.size(280.dp).background(Color.White.copy(0.1f),
                CircleShape
            ), contentAlignment = Alignment.Center){
                Image(painter = painterResource(R.drawable.fruit_basket_image),
                    "Fruit Image", Modifier.size(160.dp))
            }
        }

        Column(Modifier.fillMaxWidth().weight(0.35f).padding(24.dp,32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Get the Freshest Fruit Salad Combo",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF272140),
                    textAlign = TextAlign.Center,
                    lineHeight = 28.sp
                )

                Spacer(Modifier.height(16.dp))

                Text("We deliver the best and freshest fruit salad in town. Order for a combo today!!",
                    fontSize = 16.sp,
                    color = Color(0xFF50577E),
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp
                )

                Spacer(Modifier.height(26.dp))

                Button(onClick = {
                    onNavigateToHome()
                },
                    Modifier.fillMaxWidth().height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8C42)),
                    shape = RoundedCornerShape(16.dp)) {
                    Text("Let's Continue",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = Color.White
                        )
                }
            }

        }

    }
}


@Composable
@Preview(showBackground = true)
fun WellComeScreenPreview(modifier: Modifier = Modifier) {
    WellComeScreen()
}