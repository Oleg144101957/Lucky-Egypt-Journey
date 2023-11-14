package egypt.eleitoral.tse.br.ui.theme.shows

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import egypt.eleitoral.tse.br.App
import egypt.eleitoral.tse.br.R
import egypt.eleitoral.tse.br.ui.theme.Screens
import kotlinx.coroutines.delay


@Composable
fun Show1(navigator: NavHostController){


    LaunchedEffect(Unit){
        delay(1889)
        navigator.navigate(Screens.Screen2.target)
    }


    Image(
        painter = painterResource(id = R.drawable.bg2),
        contentDescription = "loading background",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )


    Box(modifier = Modifier
        .fillMaxSize()
    ){
        StartScreen()
    }
}

@Composable
fun BoxScope.StartScreen() {

    val text = remember {
        mutableStateOf("Loading...")
    }

    val dots = listOf(
        remember { Animatable(0.2f) },
        remember { Animatable(0.2f) },
        remember { Animatable(0.2f) },
    )

    dots.forEachIndexed { index, animatable ->
        LaunchedEffect(animatable) {
            delay(index * 200L)
            animatable.animateTo(
                targetValue = 1f, animationSpec = infiniteRepeatable(
                    animation = tween(600, easing = FastOutLinearInEasing),
                    repeatMode = RepeatMode.Reverse,
                )
            )
        }
    }

    val dys = dots.map { it.value }

    Row(
        modifier = Modifier
            .align(Alignment.Center)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        dys.forEachIndexed { _, dy ->

            Box(
                Modifier
                    .size(30.dp)
                    .scale(dy)
                    .alpha(dy)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
            )
        }
    }

    Text(
        text = text.value,
        fontSize = 48.sp,
        fontFamily = App.main_font,
        color = Color.White,
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .offset(y = (-16).dp)
    )
}