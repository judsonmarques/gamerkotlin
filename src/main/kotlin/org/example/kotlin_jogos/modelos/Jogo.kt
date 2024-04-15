package org.example.kotlin_jogos.modelos

data class Jogo(val titulo: String,
                val capa: String) {

    var descricao:String? = null
    var preco =  0.0
        constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "titulo: $titulo, \n" +
                "capa: $capa, \n" +
                "Preço R$:$preco, \n" +
                "descricao: $descricao, \n"

    }


}