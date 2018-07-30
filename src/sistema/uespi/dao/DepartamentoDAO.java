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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.uespi.modelo.Departamento;
import sistema.uespi.modelo.Funcionario;

/**
 *
 * @author Marquinhos
 */
public class DepartamentoDAO {

    private Connection conn;

    public DepartamentoDAO(Connection conn) {
        this.conn = conn;
    }

    public void addDepartamentoDao(Departamento d) {
        String sql = "INSERT INTO Departamento (nomeDepart, descricaoDepart, gerenteId,estado_depart)VALUES(?,?,?,?)";
        String sql2 = "UPDATE funcionario a inner join departamento b on a.idFunc = ? set a.id_depart = b.idDepart where a.idFunc = b.gerenteId";
        
        
        
        
        
        PreparedStatement stmt = null,stmt2 = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, d.getNomeDepart());
            stmt.setString(2, d.getDescricaoDepart());
            stmt.setLong(3, d.getGerenteid());
            stmt.setString(4,"ativo");
            stmt.execute();
            stmt2 = conn.prepareStatement(sql2);
            stmt2.setLong(1, d.getGerenteid());
            stmt2.execute();
            JOptionPane.showMessageDialog(null, "Departamento Cadastrado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Problemas no Cadastrado", "Erro ao Cadastrar", JOptionPane.INFORMATION_MESSAGE);

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    public boolean isDepartamentoDao(Departamento d) {
        boolean existe = false;
        String sql = "SELECT nomeDepart FROM Departamento WHERE nomeDepart=?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, d.getNomeDepart());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return existe;
    }

    public List<Departamento> listDepartDao() {
        List<Departamento> departamentos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Departamento ORDER BY nomeDepart";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Departamento d = new Departamento();
                d.setIdDepart(rs.getLong("idDepart"));
                d.setNomeDepart(rs.getString("nomeDepart"));
                d.setDescricaoDepart(rs.getString("descricaoDepart"));
                departamentos.add(d);
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
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return departamentos;
    }
    
    public Departamento returnDepartamentoDao(Departamento d){
        Departamento existe = null;
        String sql = "SELECT * FROM Departamento";
        PreparedStatement stmt = null;
        ResultSet rs =null;
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if(rs.next()){
                existe.setIdDepart(d.getIdDepart());
            }
            rs.close();
            stmt.close();
            return existe;
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return existe;
    }

    public Boolean gerente(Funcionario f) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existe = false;
        try {
            String sql = "SELECT gerenteId FROM Departamento where gerenteId = ( SELECT idFunc FROM Funcionario where idFunc =?)";
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, f.getIdFunc());
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                existe = true;
                return existe;
            }
           /// System.out.println(existe);
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
   }
        return existe;
    }

}
