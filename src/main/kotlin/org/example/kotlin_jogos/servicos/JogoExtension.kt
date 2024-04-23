package org.example.kotlin_jogos.servicos

import org.example.kotlin_jogos.modelos.InfoJogoJson
import org.example.kotlin_jogos.modelos.Jogo

class JogoExtension {

    fun InfoJogoJson.criaJogo(): Jogo {
        return Jogo(this.titulo, this.capa, this.preco, this.descricao)
    }
}