package org.example.kotlin_jogos.modelos

abstract class Plano(val tipo: String) {

    open fun obterValorAluguel(aluguel: Aluguel): Double{
        return aluguel.jogo.preco * aluguel.periodoAluguel.aluguelEmDias
    }
}