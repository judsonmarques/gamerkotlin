package org.example.kotlin_jogos.servicos

import com.google.gson.Gson
import org.example.kotlin_jogos.modelos.infoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun buscaJogo (id: String): infoJogo{

        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient();
        val request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build()
        val response = client
                .send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()

        val gson = Gson()
        val meuinfoJogo = gson.fromJson(json,infoJogo::class.java)

        return meuinfoJogo
    }


}