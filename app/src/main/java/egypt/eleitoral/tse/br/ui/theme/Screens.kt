package egypt.eleitoral.tse.br.ui.theme

sealed class Screens(val target: String){

    object Screen1 : Screens("butterfly")
    object Screen2 : Screens("candle")
    object Screen3 : Screens("mountain")
    object Screen4 : Screens("whisper")
    object Screen5 : Screens("jigsaw")

}