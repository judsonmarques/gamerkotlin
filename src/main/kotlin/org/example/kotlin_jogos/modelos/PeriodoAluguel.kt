package org.example.kotlin_jogos.modelos

import java.time.LocalDate
import java.time.Period

data class PeriodoAluguel(val dataInicial: LocalDate,
                          val dataFinal: LocalDate){
    val aluguelEmDias = Period.between(dataInicial, dataFinal).days
}
