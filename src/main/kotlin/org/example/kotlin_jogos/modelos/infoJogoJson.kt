package org.example.kotlin_jogos.modelos
    data class infoJogoJson(
            val titulo: String,
            val capa: String,
            val preco: Double,
            val descricao: String)

fun infoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}
