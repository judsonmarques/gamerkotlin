package org.example.kotlin_jogos.modelos

data class infoJogo(val info: infoSharkJogo) {
    override fun toString(): String {
        return info.toString()
    }
}