package org.example.kotlin_jogos.principal

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.example.kotlin_jogos.modelos.PeriodoAluguel
import org.example.kotlin_jogos.modelos.PlanoAssinatura
import org.example.kotlin_jogos.servicos.ConsumoApi
import org.springframework.boot.autoconfigure.ssl.SslProperties.Bundles.Watch.File
import java.time.LocalDate


fun main() {
    val consumo = ConsumoApi()
   val listaGamers = consumo.buscaGamer()
   val listaJogoJson = consumo.buscaJogosJson()

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)

    val jogo1 = listaJogoJson.get(1)
    val jogo2 = listaJogoJson.get(2)
    val jogo3 = listaJogoJson.get(3)
    val jogo4 = listaJogoJson.get(4)

    val periodo1 = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo4 = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(7))

    gamerCamila.alugaJogo(jogo1, periodo1)
    gamerCamila.alugaJogo(jogo2, periodo2)
    gamerCamila.alugaJogo(jogo3, periodo3)
    gamerCamila.alugaJogo(jogo4, periodo4)
    println(gamerCamila.jogoAlugados)

 gamerCamila.recomendar(11)
 gamerCamila.recomendar(7)
 gamerCamila.recomendar(8)
// println(gamerCamila)

 gamerCamila.alugaJogo(jogo1, periodo1)


 val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
 val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
 println(serializacao)

 val salvaArquivoJson = java.io.File("jogosRecomendados-${gamerCamila.nome}.json")
 salvaArquivoJson.writeText(serializacao)

}

