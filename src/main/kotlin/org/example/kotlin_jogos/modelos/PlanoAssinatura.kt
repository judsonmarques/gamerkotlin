package org.example.kotlin_jogos.modelos

class PlanoAssinatura(
        tipo:String,
        val mensalidade: Double,
        val jogoIncluidos: Int,
        val descontoReputacao: Double,
        id: Int = 0): Plano(tipo, id) {

    override fun obterValorAluguel(aluguel: Aluguel): Double {
        val totalDeJogosMes = aluguel.gamer.jogosDoMes(aluguel.periodoAluguel.dataInicial.monthValue).size

        return if (totalDeJogosMes <= jogoIncluidos ){
            0.0
        } else {
           // retorna  o valor original
            var valorOriginal = super.obterValorAluguel(aluguel)
        if (aluguel.gamer.media > 8){
            // retorna valor com desconto
            valorOriginal -= valorOriginal * descontoReputacao
        }
        valorOriginal
    }


}

    override fun toString(): String {
        return "PlanoAssinatura\n " +
                "Tipo: $tipo,\n" +
                "Id: $id," +
                "mensalidade=$mensalidade," +
                " jogoIncluidos=$jogoIncluidos," +
                " descontoReputacao=$descontoReputacao"
    }
}