package com.example.fruithubapp.view

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fruithubapp.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Column(Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(16.dp)) {

        Row(Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .padding(top = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color(0xFF27214D),
                modifier = Modifier.size(24.dp)
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Image(
                    painter = painterResource(R.drawable.shopping_basket),
                    contentDescription = "Cart",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(Modifier.height(4.dp))

                Text("My Basket",
                    fontSize = 12.sp,
                    color = Color(0xFF272140))
            }
        }

        Text("Hello Chethan,What fruit salad combo do you want today?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF272140),
            lineHeight = 28.sp,
            modifier = Modifier.padding(bottom = 24.dp))


        Row(Modifier
            .fillMaxWidth()
            .background(Color(0xFFF3F1F1), RoundedCornerShape(16.dp))
            .padding(16.dp), verticalAlignment = Alignment.CenterVertically) {

            Icon(Icons.Default.Search,"Search",
                tint = Color(0xFF86869E),
                modifier = Modifier.size(24.dp)
            )

            Spacer(Modifier.width(12.dp))

            Text("Search for fruit salad combos",
                fontSize = 14.sp,
                color = Color(0xFF86869E))

            Spacer(Modifier.weight(1f))

            Image(painter = painterResource(R.drawable.filter_list),
                "Filter",
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(Modifier.height(32.dp))

        Text(
            "Recommended Combo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            items(2){ index ->
                RecommendedComboCard(
                    name = if (index == 0)"Honey Limb Combo" else "Berry Mango Combo",
                    price = if (index == 0)"$1000" else "$800",
                    imageResource = if (index == 0) R.drawable.food_1 else R.drawable.food_2
                )
            }
        }

        LazyRow(horizontalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            items(listOf("Hottest","Popular","New Combo","Top")) { category ->

                Text(
                    text = category,
                    fontSize = 16.sp,
                    fontWeight = if (category == "Hottest") FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun RecommendedComboCard(name: String, price: String, imageResource: Int) {
    Card(
        modifier = Modifier.width(152.dp).padding(2.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(
            modifier = Modifier.padding(start = 26.dp)
        ) {
            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End) {

                Icon(imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Wishlist",
                    tint = Color(0xFFFF8C42),
                    modifier = Modifier.size(25.dp).padding(top = 4.dp, end = 6.dp)
                )
            }

            Image(painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )

            Spacer(Modifier.height(12.dp))

            Text(
                name,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.Black
            )

            Spacer(Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth().padding(end = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF8C42)
                )

                Icon(Icons.Default.Add,
                    contentDescription = null,
                    tint = Color(0xFFFF8C42),
                    modifier = Modifier.size(24.dp)
                        .background(Color(0xFFFFF2E7),
                            shape = CircleShape)
                        .padding(4.dp)
                )
            }

            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    HomeScreen()
}