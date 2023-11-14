package egypt.eleitoral.tse.br.ui.theme.shows

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInParent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavHostController
import egypt.eleitoral.tse.br.R
import egypt.eleitoral.tse.br.ui.theme.Screens

@Composable
fun Show3(navigator: NavHostController){

    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle


    DisposableEffect(lifecycle) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                (context as Activity).requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            } else if (event == Lifecycle.Event.ON_STOP) {
                (context as Activity).requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
            }
        }
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
            (context as Activity).requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
        }
    }

    val offsetX = remember { mutableStateOf(0f) }
    val offsetY = remember { mutableStateOf(0f) }


    val elRight = remember {
        mutableStateOf(Rect.Zero)
    }

    val elLeft = remember {
        mutableStateOf(Rect.Zero)
    }

    val elTop = remember {
        mutableStateOf(Rect.Zero)
    }

    val elBottom = remember {
        mutableStateOf(Rect.Zero)
    }



    val isTouchedRight = remember {
        mutableStateOf(false)
    }

    val isTouchedLeft = remember {
        mutableStateOf(false)
    }

    val isTouchedTop = remember {
        mutableStateOf(false)
    }

    val isTouchedBottom = remember {
        mutableStateOf(false)
    }





    val sensorManager = LocalContext.current.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    // Initialize the gyroscope sensor
    val gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

    // Register the gyroscope sensor listener
    val gyroscopeEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            // event.values[0] is the rate of rotation around the x-axis
            // event.values[1] is the rate of rotation around the y-axis
            // You can use these values to move the ball
            val xRotation = event.values[1]
            val yRotation = event.values[0]


            offsetX.value += xRotation
            offsetY.value += yRotation


            // Update the position of the ball based on the rotation values
            // Modify your ball position logic here

        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            // Handle accuracy changes if needed
        }
    }





    Image(
        painter = painterResource(id = R.drawable.bg1),
        contentDescription = "play background",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.symbol_filmstrips_tc),
            contentDescription = "ball",
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = offsetX.value.dp, y = offsetY.value.dp)
                .onGloballyPositioned {
                    if (elRight.value.overlaps(it.boundsInParent())) {
                        isTouchedRight.value = true
                    } else if (elLeft.value.overlaps(it.boundsInParent())) {
                        isTouchedLeft.value = true
                    } else if (elTop.value.overlaps(it.boundsInParent())) {
                        isTouchedTop.value = true
                    } else if (elBottom.value.overlaps(it.boundsInParent())) {
                        isTouchedBottom.value = true
                    }
                }
        )




        Image(
            painter = painterResource(id = R.drawable.symbol_filmstrips_tc_1),
            contentDescription = "1",
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = 64.dp)
                .border(4.dp, if (isTouchedRight.value) Color.Red else Color.White.copy(alpha = 0f))
                .onGloballyPositioned {
                    elRight.value = it.boundsInParent()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.symbol_filmstrips_tc_2),
            contentDescription = "1",
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = (-64).dp)
                .border(4.dp, if (isTouchedLeft.value) Color.Red else Color.White.copy(alpha = 0f))
                .onGloballyPositioned {
                    elLeft.value = it.boundsInParent()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.symbol_filmstrips_tc_3),
            contentDescription = "1",
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-64).dp)
                .border(4.dp, if (isTouchedTop.value) Color.Red else Color.White.copy(alpha = 0f))
                .onGloballyPositioned {
                    elTop.value = it.boundsInParent()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.symbol_filmstrips_tc_4),
            contentDescription = "1",
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 64.dp)
                .border(
                    4.dp,
                    if (isTouchedBottom.value) Color.Red else Color.White.copy(alpha = 0f)
                )
                .onGloballyPositioned {
                    elBottom.value = it.boundsInParent()
                }
        )


        if (isTouchedLeft.value && isTouchedRight.value && isTouchedBottom.value && isTouchedTop.value){

            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.9f))
            ){
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "close",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(32.dp)
                        .clickable {
                            navigator.navigate(Screens.Screen2.target)
                        }
                )

                Text(
                    text = "You win !!!",
                    color = Color.White,
                    fontSize = 32.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }


    DisposableEffect(Unit){
        sensorManager.registerListener(
            gyroscopeEventListener,
            gyroscopeSensor,
            SensorManager.SENSOR_DELAY_GAME
        )

        onDispose {
            sensorManager.unregisterListener(gyroscopeEventListener)
        }
    }
}