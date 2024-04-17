package org.example.kotlin_jogos.modelos

import java.time.LocalDate
import java.time.Period

data class Aluguel(
        val gamer: Gamer,
        val jogo: Jogo,
        val periodoAluguel: PeriodoAluguel,
        )
{
    val valorDoAluguel: Double = gamer.plano.obterValorAluguel(this)
    override fun toString(): String {
        return "Aluguel do Jogo ${jogo.titulo}, feito por ${gamer.nome} pelo valor de R$${valorDoAluguel} \n"
    }



}