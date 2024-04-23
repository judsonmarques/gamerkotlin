package org.example.kotlin_jogos.connection

import org.example.kotlin_jogos.connection.ConexaoBD.obterConexao
import org.example.kotlin_jogos.modelos.Jogo

class JogosDAO {



    fun getJogos(): List<Jogo> {

        val listaJogos = mutableListOf<Jogo>()
        val connection = obterConexao()

        if (connection != null) {
            try {
                val statement = connection.createStatement()
                val resultado = statement.executeQuery("SELECT * FROM JOGOS")

                while (resultado.next()) {
                    val id = resultado.getInt("id")
                    val titulo = resultado.getString("titulo")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val preco = resultado.getDouble("preco")

                    val jogo = Jogo(titulo, capa, preco, descricao, id)
                    listaJogos.add(jogo)

                }
                statement.close()
            } finally {
                connection.close()
            }
        }
        return listaJogos
    }

    fun adicionarJogo(jogo: Jogo) {
        val connection = obterConexao()
        val insert = "INSERT INTO JOGOS (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"

        if (connection != null) {
            try {
                val statement = connection.prepareStatement(insert)
                statement.setString(1, jogo.titulo)
                statement.setString(2, jogo.capa)
                statement.setDouble(3, jogo.preco)
                statement.setString(4, jogo.descricao)

                statement.executeUpdate()
                statement.close()

            } finally {
                connection.close()
            }
        }
    }

}