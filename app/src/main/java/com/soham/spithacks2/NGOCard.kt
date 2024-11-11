package com.soham.spithacks2

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.soham.NGO
import com.soham.spithacks2.ui.theme.darkBlue

@Composable
fun NGOCard(ngo: NGO){
    val context = LocalContext.current
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                val intent = Intent(context, NGOInfoActivity::class.java)
                Global.NGO = ngo
                context.startActivity(intent)
            }
    ){
        Column(
        ){
            Box(){
                Image(
                    painter = rememberAsyncImagePainter(ngo.foodImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .size(200.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = rememberAsyncImagePainter(ngo.donorImage),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(40.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                    )
                    Column(
                    ){
                        Text(text = ngo.name, fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                        Text(text = "Bandra, Mumbai", fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Light)
                    }
                }
            }
            //texttt
            Spacer(Modifier.height(8.dp))
            Text(
                text = ngo.feeding +" People/Day",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(Icons.Outlined.DateRange, "", tint = Color.Gray, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("4:00 PM - 10:00 PM", fontSize = 10.sp, color = Color.Gray)

                }
                Spacer(Modifier.width(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(Icons.Outlined.AccountCircle, "", tint = Color.Gray, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text(ngo.members +" Members", fontSize = 10.sp, color = Color.Gray)

                }
            }
        }
    }
}