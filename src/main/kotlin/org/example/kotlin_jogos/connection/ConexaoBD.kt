package org.example.kotlin_jogos.connection

import org.example.kotlin_jogos.modelos.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


object ConexaoBD {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "1234")
        } catch (e: SQLException) {
            e.printStackTrace()
            return null
        }
    }




}

