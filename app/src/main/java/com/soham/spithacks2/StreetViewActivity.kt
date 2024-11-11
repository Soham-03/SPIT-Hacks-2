package com.soham.spithacks2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.StreetViewPanoramaOptions
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.streetview.StreetView
import com.google.maps.android.ktx.MapsExperimentalFeature
import com.soham.spithacks2.ui.theme.SPITHacks2Theme

class StreetViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SPITHacks2Theme {
                StreetViewScreen()
            }
        }
    }
}

@OptIn(MapsExperimentalFeature::class)
@Composable
fun StreetViewScreen(){
    val LatLng = LatLng(19.044586504469358, 72.82040269045963)
    StreetView(
        streetViewPanoramaOptionsFactory = {
            StreetViewPanoramaOptions().position(LatLng)
        },
        isPanningGesturesEnabled = true,
        isStreetNamesEnabled = true,
        isUserNavigationEnabled = true,
        isZoomGesturesEnabled = true
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SPITHacks2Theme {
//        Greeting("Android")
    }
}