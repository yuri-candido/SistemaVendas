/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.model.Produtos;
import com.br.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author yurig
 */
public class ProdutosDAO {
        
    private Connection con;
    
    public ProdutosDAO() throws Exception {
        this.con = new ConnectionFactory().conexaoMySQL();
    }
    
    public void cadastrar(Produtos obj) {
        try {
            
          String sql = "insert into tb_produtos(descricao, preco, qtd_estoque,for_id) values (?,?,?,?)"; 
          
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, obj.getDescricao()); 
           stmt.setDouble(2, obj.getPreco()); 
           stmt.setInt(3, obj.getQtd_estoque());
           stmt.setInt(4,obj.getFornecedor().getId());
           
           stmt.execute();
           stmt.close();
           
           JOptionPane.showMessageDialog(null, "produto cadastrado com sucesso!");
           
           
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro!" + e);
        }
    }
    
    
    
    
}
