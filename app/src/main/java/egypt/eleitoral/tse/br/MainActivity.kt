package egypt.eleitoral.tse.br

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import egypt.eleitoral.tse.br.ui.theme.LuckyEgyptJourneyTheme
import egypt.eleitoral.tse.br.ui.theme.NavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuckyEgyptJourneyTheme {
                // A surface container using the 'background' color from the theme
                NavigationGraph()
            }
        }
    }
}