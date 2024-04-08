import org.example.kotlin_jogos.modelos.Gamer

fun main() {
    val gamer1 = Gamer("Judson", "judson@email.com")
    val gamer2 = Gamer("lais", "lais@email.com", "13/02/1988", "lais88")

    println(gamer1)
    println(gamer2)

    gamer2.usuario = "lais13"
    println(gamer2)

//    println("---------------")
//
//    gamer1.email = "judson"
//    println(gamer1)
}
