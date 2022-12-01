/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

;
import br.com.projeto.model.Fornecedores;
import com.br.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import com.br.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;


/**
 *
 * @author yurig
 */
public class FornecedorDAO {
        
    private Connection con;
    
    public FornecedorDAO() throws Exception {
        this.con = new ConnectionFactory().conexaoMySQL();
    }
    
    public void cadastrarFornecedor(Fornecedores obj){
        
        try {
            
            String sql = "insert into tb_fornecedores(nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,"
                    + "bairro, cidade,estado)" + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //PreparedStatement stmt =(PreparedStatement) con.PreparedStatement(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Cadastro com sucesso!");
            
            
            
            
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro" + erro);
        }
        
    }    
    
    
    public void excluirFornecedor(Fornecedores obj) {
            
            try {
            
            String sql = "delete from tb_fornecedores where id=?";
            
            //PreparedStatement stmt =(PreparedStatement) con.PreparedStatement(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, obj.getId());
           
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Excluído com sucesso!");
            
            
            
            
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro" + erro);
            }
        
        }   
    
    public void alterarFornecedor(Fornecedores obj) {
            
            try {
            
            String sql = "update tb_fornecedores set nome=?,cnpj=?,email=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";
                   
            
            //PreparedStatement stmt =(PreparedStatement) con.PreparedStatement(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
            
            stmt.setInt(13, obj.getId());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Alterado com sucesso!");
            
            
            
            
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro" + erro);
        }
        
    }    
    
    
    public List<Fornecedores> listarFornecedor(){
            
            try {
            
                List<Fornecedores> lista = new ArrayList<>();
                
                String sql = "select * from tb_fornecedores";
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()) {
                    
                    Fornecedores obj = new Fornecedores();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                  
                    obj.setCnpj(rs.getString("cnpj"));
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
        
    
        // listar fornecedor por nome
    public List<Fornecedores> buscarFornecedor(String nome){
            
            try {
            
                List<Fornecedores> lista = new ArrayList<>();
                
                String sql = "select * from tb_fornecedores where nome like ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nome);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()) {
                    
                    Fornecedores obj = new Fornecedores();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                  
                    obj.setCnpj(rs.getString("cnpj"));
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
        
    
    public Fornecedores consultarFornecedor(String nome) throws SQLException {
           
           try{
               
               String sql = "select * from tb_fornecedores where nome = ?";
               PreparedStatement stmt = con.prepareStatement(sql);
               stmt.setString(1, nome);
               
               ResultSet rs = stmt.executeQuery();
               Fornecedores obj = new Fornecedores();
               
               if(rs.next()) {
                   
                   obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                  
                    obj.setCnpj(rs.getString("cnpj"));
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
               JOptionPane.showMessageDialog(null, "Fornecedor não encontrado");
               return  null;
           }
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}