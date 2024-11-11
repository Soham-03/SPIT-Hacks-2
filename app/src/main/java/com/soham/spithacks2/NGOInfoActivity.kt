package com.soham.spithacks2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.rememberAsyncImagePainter
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.soham.NGO
import com.soham.spithacks2.ui.theme.Blue
import com.soham.spithacks2.ui.theme.SPITHacks2Theme
import com.soham.spithacks2.ui.theme.darkBlue


class NGOInfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SPITHacks2Theme {
                NGOInfoScreen(Global.NGO)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NGOInfoScreen(ngo: NGO){
    var listOfColors = listOf(
        Blue,
        Color.White
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOfColors,
                        startY = 0.0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
//            .padding(12.dp)
        ){
            Image(
                rememberAsyncImagePainter(ngo.foodImage),
                null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
            )
            Spacer(
                modifier = Modifier
                    .height(12.dp)
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .verticalScroll(rememberScrollState())
            ){
                Text(
                    text = "This is",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
                Text(
                    text = ngo.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = darkBlue
                )

                FlowRow(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(darkBlue),
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        Icon(
                            Icons.Filled.LocationOn,
                            "",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(4.dp)
                        )
                        Text("9.8 kms", fontSize = 12.sp, color = Color.White)
                        Spacer(Modifier.width(4.dp))
                    }
                    Spacer(Modifier.width(8.dp))
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(darkBlue),
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        Icon(
                            Icons.Filled.AccountCircle,
                            "",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(4.dp)
                        )
                        Text("1000 Members", fontSize = 12.sp, color = Color.White)
                        Spacer(Modifier.width(4.dp))
                    }
                    Spacer(Modifier.width(8.dp))
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(darkBlue),
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        Icon(
                            Icons.Filled.ThumbUp,
                            "",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(4.dp)
                        )
                        Text("VEG ONLY", fontSize = 12.sp, color = Color.White)
                        Spacer(Modifier.width(4.dp))
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(darkBlue),
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        Icon(
                            Icons.Filled.Info,
                            "",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(4.dp)
                        )
                        Text("100 People/Day", fontSize = 12.sp, color = Color.White)
                        Spacer(Modifier.width(4.dp))
                    }
                    Spacer(Modifier.width(4.dp))
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(darkBlue),
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        Icon(
                            Icons.Filled.CheckCircle,
                            "",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(4.dp)
                        )
                        Text("Verified", fontSize = 12.sp, color = Color.White)
                        Spacer(Modifier.width(4.dp))
                    }
                }
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Active Langars",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                //mapsss


                Spacer(Modifier.height(12.dp))
                val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(LatLng(19.044637211850077, 72.82045633582106), 10f)
                }
                GoogleMap(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(RoundedCornerShape(18.dp)),
                    cameraPositionState = cameraPositionState
                ) {
//            Marker(
//                state = singaporeMarkerState,
//                title = "Singapore",
//                snippet = "Marker in Singapore"
//            )
//            Marker(
//                state = singaporeMarkerState2,
//                title = "Singapore",
//                snippet = "Marker in Singapore"
//            )
                    val context = LocalContext.current
                    MarkerInfoWindow(
                        state = MarkerState(position = LatLng(19.044637211850077, 72.82045633582106)),
                        onInfoWindowClick = {
                            val intent = Intent(context, StreetViewActivity::class.java)
                            context.startActivity(intent)
                        },
//                icon = BitmapDescriptorFactory.fromResource(R.drawable.ic_cargo_select)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .border(
                                    BorderStroke(1.dp, Color.Black),
                                    RoundedCornerShape(10)
                                )
                                .clip(RoundedCornerShape(10))
                                .background(darkBlue)
                                .padding(8.dp)
                        ) {
                            Text("Bhavans Langar", fontWeight = FontWeight.Bold, color = Color.White)
                            Text("Feeding 20 Children", fontWeight = FontWeight.Medium, color = Color.White)
                        }
                    }
                }
                Spacer(
                    Modifier.height(20.dp)
                )
            }
        }

        Row(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp)
        ){
            val context = LocalContext.current
            Button(
                onClick = {
                    val uri =
                        "http://maps.google.com/maps?daddr=19.223217,73.157940" + "+to:19.229584206084226,73.1593526332295"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.setClassName(
                        "com.google.android.apps.maps",
                        "com.google.android.maps.MapsActivity"
                    )
                    if (intent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(intent)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = darkBlue,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(40.dp),
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .weight(8f)
            ) {
                Text(
                    "Start Navigation",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                )
            }
            Spacer(Modifier.width(6.dp))
            Button(
                onClick = {
                    val phone_intent = Intent(Intent.ACTION_CALL)
                    // Set data of Intent through Uri by parsing phone number
                    phone_intent.setData(Uri.parse("tel:9307377878"))


                    // start Intent
                    context.startActivity(phone_intent)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = darkBlue,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(40.dp),
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .weight(8f)
            ){
                Text(
                    "Contact",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SPITHacks2Theme {
//        NGOInfoScreen()
    }
}