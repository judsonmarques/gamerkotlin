package org.example.kotlin_jogos.servicos

import org.example.kotlin_jogos.modelos.Gamer
import org.example.kotlin_jogos.modelos.infoGamerJson

fun infoGamerJson.criaGamer(): Gamer {

    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)

}