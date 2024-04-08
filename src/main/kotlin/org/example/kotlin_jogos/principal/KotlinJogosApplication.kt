package org.example.kotlin_jogos.principal
import org.example.kotlin_jogos.modelos.Gamer
import org.example.kotlin_jogos.modelos.Jogo
import org.example.kotlin_jogos.servicos.ConsumoApi
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*


@SpringBootApplication
class KotlinJogosApplication

fun main() {

    var meuJogo: Jogo? = null

    val leitura = Scanner(System.`in`)
    val Gamer = Gamer.criarGamer(leitura)
    println("Gamer criado com sucesso! ")
    println(Gamer)

    do {

        println("Digite um número:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val infoJogo = buscaApi.buscaJogo(busca)


        val resultado = runCatching {
            meuJogo = Jogo(infoJogo.info.title, infoJogo.info.thumb)

        }

        resultado.onFailure {
            println("Id inexistente, tente novamente.")
        }
        resultado.onSuccess {
            println("Jogo encontrado: " + meuJogo?.titulo)
            println("Deseja inserir uma descrição personalizada? S/N ")
            val opcao = leitura.nextLine()
            if (opcao.equals("S", true)) {
                println("Insira a sua descrição personalizada ")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {

                meuJogo?.descricao = meuJogo?.titulo

            }

            Gamer.jogosBuscados.add(meuJogo)
        }


        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("s",true))


    println("Jogos buscados: ")
    println(Gamer.jogosBuscados)

    println("Jogos por títulos: ")
    Gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    Gamer.jogosBuscados.forEach {
        println("Titulos: " + it?.titulo)
    }


    println("Consulta finalizada com sucesso ")

}
