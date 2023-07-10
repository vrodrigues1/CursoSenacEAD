package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
        
    public class conectaDAO{
    
    // Variaveis SQL
    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    // Variaveis para conexão
    String url = "jdbc:mysql://localhost:3306/uc11";
    String user = "root";
    String password = "123456";

        
        
    public boolean conectar() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso");
            return true;

        } catch (ClassNotFoundException | SQLException ex) {

            System.out.println("Falha na conexão com o banco" + " " + ex.getMessage());
            return false;

        }
    }

    public void desconecta() {

        try {

            conn.close();
            System.out.println("Conexão encerrada com sucesso");

        } catch (SQLException ex) {

        }

    }
}