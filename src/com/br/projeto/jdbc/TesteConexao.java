/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projeto.jdbc;

import javax.swing.JOptionPane;

/**
 * 
 * @author yurig
 */
public class TesteConexao {
        
    public static void main(String[] args) {
        
        try {
            
           // Class.forName("com.mysql.jdbc.Driver");
            new ConnectionFactory().conexaoMySQL();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Ops, aconteceu um erro!"+ e);
        }
    }
}
