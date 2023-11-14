package egypt.eleitoral.tse.br.ui.theme.shows

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import egypt.eleitoral.tse.br.App
import egypt.eleitoral.tse.br.R
import egypt.eleitoral.tse.br.ui.theme.Screens
import kotlin.system.exitProcess

@Composable
fun Show2(navigator: NavHostController){

    val ctx = LocalContext.current

    Image(
        painter = painterResource(id = R.drawable.bg1),
        contentDescription = "menu background",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.money),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Column (modifier = Modifier
            .align(Alignment.Center)
        ){
            Box (modifier = Modifier.padding(16.dp)){
                Image(
                    painter = painterResource(id = R.drawable.button),
                    contentDescription = "button play",
                    modifier = Modifier
                        .clickable {
                            navigator.navigate(Screens.Screen3.target)
                        }
                )

                Text(
                    text = "Play",
                    color = Color.White,
                    fontFamily = App.main_font,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

            Box (modifier = Modifier.padding(16.dp)){
                Image(
                    painter = painterResource(id = R.drawable.button),
                    contentDescription = "button play",
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_MAIN)
                        intent.addCategory(Intent.CATEGORY_HOME)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        ctx.startActivity(intent)
                        (ctx as? Activity)?.finish()
                        exitProcess(0)
                    }
                )

                Text(
                    text = "Exit",
                    color = Color.White,
                    fontFamily = App.main_font,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}