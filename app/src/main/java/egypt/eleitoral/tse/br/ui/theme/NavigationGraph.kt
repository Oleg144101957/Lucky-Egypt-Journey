package egypt.eleitoral.tse.br.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import egypt.eleitoral.tse.br.ui.theme.shows.Show1
import egypt.eleitoral.tse.br.ui.theme.shows.Show2
import egypt.eleitoral.tse.br.ui.theme.shows.Show3
import egypt.eleitoral.tse.br.ui.theme.shows.Show4
import egypt.eleitoral.tse.br.ui.theme.shows.Show5

@Composable
fun NavigationGraph(){

    val navigator = rememberNavController()

    NavHost(navController = navigator, startDestination = Screens.Screen1.target){

        composable(route = Screens.Screen1.target){
            Show1(navigator = navigator)
        }

        composable(route = Screens.Screen2.target){
            Show2(navigator = navigator)
        }


        composable(route = Screens.Screen3.target){
            Show3(navigator = navigator)
        }


        composable(route = Screens.Screen4.target){
            Show4(navigator = navigator)
        }


        composable(route = Screens.Screen5.target){
            Show5(navigator = navigator)
        }
    }
}