package com.example.location

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import com.example.location.location.LatandLong
import com.example.location.location.LocationManager
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val locationManager= LocationManager()
            val userLocation = locationManager.getUserLocation(context = this@MainActivity)
            App(userLocation)
        }
    }
}

@Composable
fun App(userLocation: LatandLong){
//    delay(1000)
    val lat by remember {
        mutableStateOf(userLocation?.latitude)
    }
    val lon by remember {
        mutableStateOf(userLocation?.longitude)
    }

//    if(lat!=null && lon !=null){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Your Location")
            Text(text = "Latitude: $lat Longitude: $lon")
            Log.d("LocationManager", "Latitude: $lat Longitude: $lon")
        }
//    }
//    else{
//        Text(text = "Loading...")
//    }

}
