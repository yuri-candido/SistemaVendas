/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.model.Clientes;
import com.br.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author yurig
 */
public class ClientesDAO {
    
    private Connection con;
    
    public ClientesDAO() throws Exception {
        this.con = new ConnectionFactory().conexaoMySQL();
    }
    
    public void cadastrarCliente(Clientes obj){
        
        try {
            
            String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,"
                    + "bairro, cidade,estado)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //PreparedStatement stmt =(PreparedStatement) con.PreparedStatement(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Cadastro com sucesso!");
            
            
            
            
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro" + erro);
        }
        
    }    
        public List<Clientes> listarClientes(){
            
            try {
            
                List<Clientes> lista = new ArrayList<>();
                
                String sql = "select * from tb_clientes";
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()) {
                    
                    Clientes obj = new Clientes();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setTelefone(rs.getString("telefone"));
                    obj.setCelular(rs.getString("celular"));
                    obj.setCep(rs.getString("cep"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setNumero(rs.getInt("numero"));
                    obj.setComplemento(rs.getString("complemento"));
                    obj.setBairro(rs.getString("bairro"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setUf(rs.getString("estado"));
                    
                    lista.add(obj);
                    
                }
                
                return lista;
                
                
            }   catch (SQLException erro){
                    JOptionPane.showMessageDialog(null, "erro"+erro);
                    return null;
                }
        
        }
        
        
        public void excluirCliente(Clientes obj) {
            
            try {
            
            String sql = "delete from tb_clientes where id=?";
            
            //PreparedStatement stmt =(PreparedStatement) con.PreparedStatement(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, obj.getId());
           
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Exclu??do com sucesso!");
            
            
            
            
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro" + erro);
            }
        
        }   
        
        public void alterarCliente(Clientes obj) {
            
            try {
            
            String sql = "update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";
                   
            
            //PreparedStatement stmt =(PreparedStatement) con.PreparedStatement(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setInt(14, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Alterado com sucesso!");
            
            
            
            
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro" + erro);
        }
        
    }    
            
            
       public List<Clientes> buscarCliente(String nome){
            
            try {
            
                List<Clientes> lista = new ArrayList<>();
                
                String sql = "select * from tb_clientes where nome like ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nome);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()) {
                    
                    Clientes obj = new Clientes();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setTelefone(rs.getString("telefone"));
                    obj.setCelular(rs.getString("celular"));
                    obj.setCep(rs.getString("cep"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setNumero(rs.getInt("numero"));
                    obj.setComplemento(rs.getString("complemento"));
                    obj.setBairro(rs.getString("bairro"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setUf(rs.getString("estado"));
                    
                    lista.add(obj);
                    
                }
                
                return lista;
                
                
            }   catch (SQLException erro){
                    JOptionPane.showMessageDialog(null, "erro"+erro);
                    return null;
                }
        
        }   
       
       
       public Clientes consultarNome(String nome) throws SQLException {
           
           try{
               
               String sql = "select * from tb_clientes where nome = ?";
               PreparedStatement stmt = con.prepareStatement(sql);
               stmt.setString(1, nome);
               
               ResultSet rs = stmt.executeQuery();
               Clientes obj = new Clientes();
               
               if(rs.next()) {
                   
                   obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setTelefone(rs.getString("telefone"));
                    obj.setCelular(rs.getString("celular"));
                    obj.setCep(rs.getString("cep"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setNumero(rs.getInt("numero"));
                    obj.setComplemento(rs.getString("complemento"));
                    obj.setBairro(rs.getString("bairro"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setUf(rs.getString("estado"));
                   
               }
               return obj;
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "cliente n??o encontrado");
               return  null;
           }
       }
       
       
       // buscar cliente por cpf
        public Clientes buscaporCpf(String cpf) throws SQLException {
           
           try{
               
               String sql = "select * from tb_clientes where cpf = ?";
               PreparedStatement stmt = con.prepareStatement(sql);
               stmt.setString(1, cpf);
               
               ResultSet rs = stmt.executeQuery();
               Clientes obj = new Clientes();
               
               if(rs.next()) {
                   
                   obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setTelefone(rs.getString("telefone"));
                    obj.setCelular(rs.getString("celular"));
                    obj.setCep(rs.getString("cep"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setNumero(rs.getInt("numero"));
                    obj.setComplemento(rs.getString("complemento"));
                    obj.setBairro(rs.getString("bairro"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setUf(rs.getString("estado"));
                   
               }
               return obj;
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "cliente n??o encontrado");
               return  null;
           }
       }
       
       
       
       
       
       
       
       
       
            
}
        
        
        
        
        
        
        

