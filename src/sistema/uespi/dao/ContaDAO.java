/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.uespi.modelo.Conta;
import sistema.uespi.modelo.Funcionario;

/**
 *
 * @author Marquinhos
 */
public class ContaDAO {

    private Connection conn;

    public ContaDAO(Connection conn) {
        this.conn = conn;
    }

    public void addConta(Conta c) {
        String sql = "INSERT INTO Conta (func_id, email, senha, estadoConta) VALUES(?,?,?,?)";
        PreparedStatement stmt = null;
        try {
          
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, c.getFuncionario().getIdFunc());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getSenha());
            stmt.setString(4, "ativo");
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Conta de Login criada.", "Confirmação!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Conta getContaAcesso(Conta c) {
        Conta conta = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Conta WHERE email=? AND senha=?";

        try {
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getEmail());
            stmt.setString(2, c.getSenha());
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Funcionario f = new Funcionario();
                conta = new Conta();
                f.setIdFunc(rs.getLong("func_id"));
                conta.setFuncionario(f);
                conta.setEmail(rs.getString("email"));
                conta.setSenha(rs.getString("senha"));
                conta.setEstadoConta(rs.getString("estadoConta"));

            }
            conn.commit();
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            try {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Erro na Autenticação.", "Erro!", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex1) {
                Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return conta;
    }

    public boolean isEmailConta(Conta c) {
        boolean existe = false;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT email FROM Conta WHERE email=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getEmail());
            rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return existe;
    }
    public boolean isIdConta(Conta c){
        boolean existe = false;
        String sql = "SELECT func_id FROM Conta WHERE func_id=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, c.getFuncionario().getIdFunc());
            rs = stmt.executeQuery();
            if(rs.next()){
                existe = true;
            }
            rs.close();
            stmt.close();
            return existe;
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return existe;
    }

    public void update(Long id, String retorno) {
        try {
            String sql = "UPDATE conta SET estadoConta=? WHERE func_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, retorno);
        stmt.setLong(2, id);
        stmt.execute();
        } catch (Exception e) {
        }
        
    }
}
