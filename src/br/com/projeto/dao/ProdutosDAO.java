/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Produtos;
import com.br.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
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
    
    public List<Produtos> listarProdutos(){
        
        try {
            
            List<Produtos> lista = new ArrayList<>();
            
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p " +
                "inner join tb_fornecedores as f on (p.for_id = f.id)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString(("f.nome")));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
                
            }
            
            return lista;
            
            
            
        } catch (Exception e) {
            
               return null;
        }
      
     
        
        
        
    }
    
    
    
    
    public void alterar(Produtos obj) {
        try {
            
          String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?,for_id=? where id=?";
          
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, obj.getDescricao()); 
           stmt.setDouble(2, obj.getPreco()); 
           stmt.setInt(3, obj.getQtd_estoque());
           stmt.setInt(4,obj.getFornecedor().getId());
           stmt.setInt(5, obj.getId());
           
           stmt.execute();
           stmt.close();
           
           JOptionPane.showMessageDialog(null, "produto alterado com sucesso!");
           
           
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro!" + e);
        }
    }
    
    public void excluir(Produtos obj) {
            
            try {
            
            String sql = "delete from tb_produtos where id=?";
            
            //PreparedStatement stmt =(PreparedStatement) con.PreparedStatement(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, obj.getId());
           
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Produto excluído com sucesso!");
            
            
            
            
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro" + erro);
            }
        
    }       
     public List<Produtos> listarPorNome(String nome){
        
        try {
            
            List<Produtos> lista = new ArrayList<>();
            
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p " +
                "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString(("f.nome")));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
                
            }
            
            return lista;
            
            
            
        } catch (Exception e) {
            
               return null;
        }
     }  
     
        public Produtos consultaPorNome(String nome){
        
        try {
            
            List<Produtos> lista = new ArrayList<>();
            
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p " +
                "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();
            
            
            if(rs.next()) {
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString(("f.nome")));
                
                obj.setFornecedor(f);
                                             
            }
            
            return obj;
            
            
            
        } catch (Exception e) {
            
               return null;
        }
        
        
    }        
            
            
            
            
            // buscar produto por codigo
   public Produtos buscaPorCodigo(int id){
        
        try {
            
            List<Produtos> lista = new ArrayList<>();
            
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p " +
                "inner join tb_fornecedores as f on (p.for_id = f.id) where p.id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();
            
            
            if(rs.next()) {
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString(("f.nome")));
                
                obj.setFornecedor(f);
                                             
            }
            
            return obj;
            
            
            
        } catch (Exception e) {
            
               return null;
        }
        
        
    }        
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }   
    
               
            
            
            
            
            
            
            
            
            
            
            
            
          
    
    
    
    
    
          
    
    
    
       
    
    
    
    
    
    
    
    

