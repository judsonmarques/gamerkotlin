import org.example.kotlin_jogos.connection.JogosDAO
import org.example.kotlin_jogos.modelos.Jogo

fun main(){

    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")

    val jogosDAO = JogosDAO()
    jogosDAO.adicionarJogo(jogo)

    val listaJogos: List<Jogo> = jogosDAO.getJogos()
    println(listaJogos)
}