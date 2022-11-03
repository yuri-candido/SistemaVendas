/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projeto.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author yurig
 */
public class ConnectionFactory {
    
     private static final String USUARIO = "root";
     private static final String SENHA= "123456";
     private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bdvendas";
    
   // public Connection getConnection() {
             
    public static Connection conexaoMySQL() throws Exception {
            
                
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USUARIO, SENHA);
		
		return connection;
	}
	
	public static void man(String[] args) throws Exception {
		Connection con = conexaoMySQL();
		
		if (con!= null) {
			System.out.print("Conexão obtida!");
			con.close();
		}
	}
    }

