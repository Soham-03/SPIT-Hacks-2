package com.soham.spithacks2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class NGO(
    val name: String,
    val peopleServed: Int,
    val location: String
)

@Composable
fun NGOLeaderboardScreen() {
    val primaryTeal = Color(0xFF3D8D89)
    val lightTeal = Color(0xFFE5F0F0)

    val ngos = listOf(
        NGO("Akshaya Patra Foundation", 984500, "Mumbai"),
        NGO("Feeding Smiles", 956200, "Delhi"),
        NGO("Annapurna Trust", 898700, "Bangalore"),
        NGO("Food Warriors", 845900, "Chennai"),
        NGO("Roti Bank", 787300, "Pune"),
        NGO("Seva Kitchen Network", 765400, "Hyderabad"),
        NGO("Hunger Heroes", 743200, "Kolkata"),
        NGO("Food for Life", 721000, "Ahmedabad"),
        NGO("Helping Hands Foundation", 698500, "Jaipur"),
        NGO("Share My Meal", 676300, "Lucknow"),
        NGO("Food Bank India", 654200, "Chandigarh"),
        NGO("Meals of Hope", 632100, "Indore"),
        NGO("Bhook Mitao", 610000, "Bhopal"),
        NGO("Anna Daan Foundation", 587900, "Nagpur"),
        NGO("Food Connect", 565800, "Surat"),
        NGO("Mighty Meals", 543700, "Vadodara"),
        NGO("Feed the Need", 521600, "Cochin"),
        NGO("Joy of Giving", 499500, "Vizag"),
        NGO("People's Kitchen", 477400, "Patna"),
        NGO("Community Food Share", 455300, "Ranchi")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Header with total impact
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = "NGO Impact Leaders",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Total Impact: ${ngos.sumOf { it.peopleServed }.toString().chunked(3).joinToString(",")} people served",
                fontSize = 14.sp,
                color = primaryTeal,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(ngos.sortedByDescending { it.peopleServed }) { ngo ->
                NGOLeaderboardItem(
                    ngo = ngo,
                    rank = ngos.sortedByDescending { it.peopleServed }.indexOf(ngo) + 1,
                    primaryTeal = primaryTeal,
                    lightTeal = lightTeal
                )
            }
        }
    }
}

@Composable
fun NGOLeaderboardItem(
    ngo: NGO,
    rank: Int,
    primaryTeal: Color,
    lightTeal: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = when (rank) {
                1 -> Color(0xFFFFF7E6) // Gold tint for #1
                2 -> Color(0xFFF5F5F5) // Silver tint for #2
                3 -> Color(0xFFFFF1E6) // Bronze tint for #3
                else -> lightTeal
            }
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Rank Circle with different colors for top 3
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        when (rank) {
                            1 -> Color(0xFFFFB800) // Gold
                            2 -> Color(0xFFC0C0C0) // Silver
                            3 -> Color(0xFFCD7F32) // Bronze
                            else -> primaryTeal
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "#$rank",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            // NGO Info
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = ngo.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = ngo.location,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            // People Served Count
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${ngo.peopleServed}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryTeal
                )
                Text(
                    text = "people served",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}