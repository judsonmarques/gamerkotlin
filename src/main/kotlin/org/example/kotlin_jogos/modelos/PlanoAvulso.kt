package org.example.kotlin_jogos.modelos

class PlanoAvulso(tipoDePlano: String, id: Int = 0): Plano(tipoDePlano, id) {

    override fun obterValorAluguel(aluguel: Aluguel): Double {
        var valorOriginal = super.obterValorAluguel(aluguel)
        if (aluguel.gamer.media > 8) {
            valorOriginal -= valorOriginal * 0.1
        }
        return valorOriginal

    }

    override fun toString(): String {
        return "PlanoAvulso," +
                "Tipo: $tipo," +
                "Id: $id"

    }
}
