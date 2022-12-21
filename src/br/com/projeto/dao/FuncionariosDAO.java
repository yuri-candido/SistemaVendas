/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.model.Clientes;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.view.Frmlogin;
import br.com.projeto.view.Frmmenu;
import com.br.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author yurig
 */
public class FuncionariosDAO {
    
    // Conexao
    
    private Connection con;
    
    public FuncionariosDAO() throws Exception {
        this.con = new ConnectionFactory().conexaoMySQL();
    }
    
    // Método cadastrar 
    
    public void cadastrarFuncionarios(Funcionarios obj){
        
        try {
            
            String sql = "insert into tb_funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,"
                    + "bairro, cidade,estado)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //PreparedStatement stmt =(PreparedStatement) con.PreparedStatement(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Cadastro com sucesso!");
            
            
            
            
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro" + erro);
        }
        
    }
    
    // método alterarFuncionario
    
        public void alterarFuncionarios(Funcionarios obj) {
            
            try {
            
            String sql = "update tb_funcionarios set nome=?,rg=?,cpf=?,email=?, senha=?, cargo=?, nivel_acesso =?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";
                   
            
            //PreparedStatement stmt =(PreparedStatement) con.PreparedStatement(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());
            stmt.setInt(17, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Alterado com sucesso!");
            
            
            
            
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro" + erro);
        }
        
    }    
    
    // metodo excluirFuncionario
    
    
    public void excluirFuncionarios(Funcionarios obj) {
            
            try {
            
            String sql = "delete from tb_funcionarios where id=?";
            
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
    
    
    
    // metodo listar funcionarios
    public List<Funcionarios> listarFuncionarios(){
            
            try {
            
                List<Funcionarios> lista = new ArrayList<>();
                
                String sql = "select * from tb_funcionarios";
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()) {
                    
                    Funcionarios obj = new Funcionarios();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setCargo(rs.getString("cargo"));
                    obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
    
    
        public Funcionarios consultarNome(String nome) throws SQLException {
           
           try{
               
               String sql = "select * from tb_funcionarios where nome = ?";
               PreparedStatement stmt = con.prepareStatement(sql);
               stmt.setString(1, nome);
               
               ResultSet rs = stmt.executeQuery();
               Funcionarios obj = new Funcionarios();
               
               if(rs.next()) {
                   
                   obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setCargo(rs.getString("cargo"));
                    obj.setNivel_acesso(rs.getString("nivel_acesso"));               
                    
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
               JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
               return  null;
           }
       
        
        
        
    } 
        
        
        public List<Funcionarios> buscarCliente(String nome){
            
            try {
            
                List<Funcionarios> lista = new ArrayList<>();
                
                String sql = "select * from tb_funcionarios where nome like ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nome);
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()) {
                    
                    Funcionarios obj = new Funcionarios();
                    
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setCargo(rs.getString("cargo"));
                    obj.setNivel_acesso(rs.getString("nivel_acesso"));                        
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
        
        
    public void efetuarLogin(String email, String senha){
        
        try{
            String sql = "select * from tb_funcionarios where email = ? and senha =? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                Frmmenu tela = new Frmmenu();
                tela.usuariologado = rs.getString("nome");
                tela.setVisible(true);
                
                
            } else {
                 JOptionPane.showMessageDialog(null, "Dados incorretos!");
                 new Frmlogin().setVisible(true);
            }
            
        } catch(Exception erro) {
             JOptionPane.showMessageDialog(null, "erro:"+ erro);
        }
        
        
    }    
    
}
