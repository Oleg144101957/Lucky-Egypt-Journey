package egypt.eleitoral.tse.br

import android.app.Application
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

class App : Application() {

    override fun onCreate() {
        super.onCreate()

    }


    companion object{
        val main_font = FontFamily(Font(R.font.bevan_regular))
    }

}