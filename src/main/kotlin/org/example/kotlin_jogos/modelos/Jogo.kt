package org.example.kotlin_jogos.modelos

import com.google.gson.annotations.Expose
import java.math.BigDecimal

data class Jogo(
                @Expose val titulo: String,
                @Expose val capa: String) {

    var id = 0
    var descricao:String? = null
    var preco =  0.0
        constructor(titulo: String, capa: String, preco: Double, descricao: String, id:Int = 0):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id

    }
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "titulo: $titulo, \n" +
                "capa: $capa, \n" +
                "Preço R$:$preco, \n" +
                "descricao: $descricao, \n" +
                "id: $id"

    }


}