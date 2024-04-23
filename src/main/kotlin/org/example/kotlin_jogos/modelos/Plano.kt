package org.example.kotlin_jogos.modelos

abstract class Plano(val tipo: String, var id: Int = 0) {



    open fun obterValorAluguel(aluguel: Aluguel): Double{
        return aluguel.jogo.preco * aluguel.periodoAluguel.aluguelEmDias
    }
}