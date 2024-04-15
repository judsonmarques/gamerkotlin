package org.example.kotlin_jogos.servicos

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.kotlin_jogos.modelos.*
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun consomeDados(endereco: String): String {

        val client: HttpClient = HttpClient.newHttpClient();
        val request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build()
        val response = client
                .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun buscaJogo (id: String): infoJogo{

        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consomeDados(endereco)


        val gson = Gson()
        val meuinfoJogo = gson.fromJson(json,infoJogo::class.java)

        return meuinfoJogo
    }

    fun buscaGamer (): List<Gamer>{

        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consomeDados(endereco)


        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<infoGamerJson>>() {}.type
        val listaGamer:List<infoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida =  listaGamer.map { infoGamerJson -> infoGamerJson.criaGamer()  }

        return listaGamerConvertida
    }

    fun buscaJogosJson(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consomeDados(endereco)

        val gson = Gson()
        val meuJogoTipo = object : TypeToken<List<infoJogoJson>>() {}.type
        val listaJogo: List<infoJogoJson> = gson.fromJson(json, meuJogoTipo)

        val listaJogoConvertida = listaJogo.map { infoJogoJson -> infoJogoJson.criaJogo() }

        return listaJogoConvertida
    }


}