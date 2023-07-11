package DAO;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
        
    public class conectaDAO{

    // Variaveis para conexão
    public static final String url = "jdbc:mysql://localhost:3306/uc11";
    public static final String user = "root";
    public static final String password = "123456";

    public static Connection connectDB(){
        Connection conn = null;
        
        try {
        
            conn = DriverManager.getConnection(url,user,password);
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }
    
}