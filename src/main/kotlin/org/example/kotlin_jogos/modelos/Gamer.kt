package org.example.kotlin_jogos.modelos

import lombok.experimental.NonFinal
import java.time.LocalDate
import java.time.Period
import java.util.Scanner
import kotlin.random.Random

data class Gamer(val nome: String, var email: String): Recomendavel{
    var id = 0
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value){
            field = value
            if(idInterno.isNullOrBlank()){
                criarIdInterno()
            }
        }

    var idInterno: String? = null
        private set


    var plano: Plano = PlanoAvulso("BRONZE")
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogoAlugados = mutableListOf<Aluguel>()
    private val jogosAlugados = mutableListOf<Aluguel>()
    private val listaNotas = mutableListOf<Int>()
    val jogosRecomendados= mutableListOf<Jogo>()



    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (nota < 1 || nota > 10) {
            println("Nota inválida. Insira uma nota entre 1 e 10")
        } else {
            listaNotas.add(nota)
        }
    }

//    fun recomendarJogo(jogo: Jogo, nota: Int) {
//        jogo.recomendar(nota)
//        jogosRecomendados.add(jogo)
//    }


    constructor(nome: String, email: String, dataNascimento: String,  usuario: String) : this (nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        this.id = id
        criarIdInterno()

    }

//    init{
//        if(nome.isNullOrBlank()){
//            throw IllegalArgumentException("Nome não pode ficar em branco")
//        }
//        this.email = validarEmail()
//           }


    override fun toString(): String {
        return "Gamer:\n" +
                "(nome=' $nome'\n" +
                " email=' $email'\n" +
                " dataNascimento= $dataNascimento,\n" +
                " usuario= $usuario\n" +
                " idInterno= $idInterno\n" +
                "Reputação= $media\n" +
                "Id: $id"
    }


    fun criarIdInterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        this.idInterno = "$usuario#$tag"


    }

    fun validarEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)){
            return email
        } else{
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun alugaJogo(jogo: Jogo, periodoAluguel: PeriodoAluguel): Aluguel{
        val aluguel = Aluguel(this, jogo, periodoAluguel)
        jogoAlugados.add(aluguel)

        return aluguel

    }

    fun jogosDoMes(mes:Int): List<Jogo> {
        return jogosAlugados
                .filter { aluguel ->  aluguel.periodoAluguel.dataInicial.monthValue == mes}
                .map { aluguel ->  aluguel.jogo}
    }


    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else {
                return Gamer (nome, email)
            }

        }
    }

}


