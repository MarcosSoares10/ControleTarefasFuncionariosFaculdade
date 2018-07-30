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
import sistema.uespi.modelo.Endereco;
import sistema.uespi.modelo.Funcionario;
import sistema.uespi.util.FormattData;

/**
 *
 * @author Marquinhos
 */
public class FuncionarioDAO {

    private Connection conn;

    public FuncionarioDAO(Connection conn) {
        this.conn = conn;
    }

    public void addFuncionarioDao(Funcionario f) {
        PreparedStatement stmtFunc = null;
        PreparedStatement stmtBuscaIdFunc = null;
        PreparedStatement stmtEnd = null;
        ResultSet rs = null;
        try {
            String sqlFunc = "INSERT INTO Funcionario (nome, cpf, dataNasc, sexo, numCelular,estado_func) VALUES (?,?,?,?,?,?)";
        //    conn.setAutoCommit(false);
            stmtFunc = conn.prepareStatement(sqlFunc);
            stmtFunc.setString(1, f.getNome());
            stmtFunc.setString(2, f.getCpf());
            stmtFunc.setDate(3, new FormattData().dataSql(f.getDataNasc()));
            stmtFunc.setString(4, f.getSexo());
            stmtFunc.setString(5, f.getNumCelular());
            stmtFunc.setString(6, "ativo");
            stmtFunc.execute();

            String sqlBuscaIdFunc = "SELECT idFunc FROM Funcionario WHERE cpf=?";
            stmtBuscaIdFunc = conn.prepareStatement(sqlBuscaIdFunc);
            stmtBuscaIdFunc.setString(1, f.getCpf());
            rs = stmtBuscaIdFunc.executeQuery();

            rs.first();
            Long func_id = rs.getLong("idFunc");

            String sqlEnd = "INSERT INTO Endereco( func_id,estado, cidade, bairro, logradouro, cep) VALUES (?,?,?,?,?,?)";
            stmtEnd = conn.prepareStatement(sqlEnd);
            stmtEnd.setLong(1, func_id);
            stmtEnd.setString(2, f.getEndereco().getEstado());
            stmtEnd.setString(3, f.getEndereco().getCidade());
            stmtEnd.setString(4, f.getEndereco().getBairro());
            stmtEnd.setString(5, f.getEndereco().getLogradouro());
            stmtEnd.setString(6, f.getEndereco().getCep());
            stmtEnd.execute();
     //       conn.commit();
            JOptionPane.showMessageDialog(null, "Funcionario Cadastrado", "Cadatro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrado Funcionario ", "Erro ao Cadatrar", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            if (conn != null) {

                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } finally {
            if (stmtFunc != null) {
                try {
                    stmtFunc.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmtEnd != null) {
                try {
                    stmtEnd.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmtBuscaIdFunc != null) {
                try {
                    stmtBuscaIdFunc.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean isCpfDao(Funcionario f) {
        boolean existe = false;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT cpf FROM Funcionario WHERE cpf=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, f.getCpf());
            rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return existe;
    }

    public Funcionario getFuncionarioViaCpfDao(Funcionario f) {
        Funcionario func = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Funcionario WHERE cpf=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, f.getCpf());
             rs = stmt.executeQuery();

            if (rs.next()) {
                func = new Funcionario();
                func.setIdFunc(rs.getLong("idFunc"));
                func.setNome(rs.getString("nome"));
                func.setCpf(rs.getString("cpf"));
                func.setDataNasc(rs.getDate("dataNasc"));
                func.setSexo(rs.getString("sexo"));
                func.setNumCelular(rs.getString("numCelular"));
                }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return func;
    }
    
    public Funcionario getFuncionarioViaIdDao(Funcionario f) {
        Funcionario func = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Funcionario WHERE idFunc=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, f.getIdFunc());
            rs = stmt.executeQuery();

            if (rs.next()) {
                func = new Funcionario();
                func.setIdFunc(rs.getLong("idFunc"));
                func.setNome(rs.getString("nome"));
                func.setCpf(rs.getString("cpf"));
                func.setDataNasc(rs.getDate("dataNasc"));
                func.setSexo("sexo");
                func.setNumCelular("numCelular");
                func.setId_depart(rs.getLong("id_depart"));
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return func;
    }
    
    
    public Boolean gerente (Funcionario f){
    boolean existe = false;
    String sql = "SELECT gerenteId FROM departamento where gerenteId=10 ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            System.out.println(f.getIdFunc());
           
// stmt.setLong(1, f.getIdFunc());
            //ResultSet rs = stmt.executeQuery();
          //  System.out.println(rs.getLong("gerenteId"));
//            if(rs.next()){
  //          existe = true;
      //      return existe;
        //    }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return existe;
    }

    public void updateFuncionario(Long id,String retorno) {
      
        
        try {
            String sql = "update Funcionario set estado_func=? WHERE idFunc=?";
             PreparedStatement stm = conn.prepareStatement(sql);
             stm.setString(1,retorno);
             stm.setLong(2, id);
             stm.execute();
      
                conn.close();
            
        } catch (Exception e) {
        }
    }
   
  

}
