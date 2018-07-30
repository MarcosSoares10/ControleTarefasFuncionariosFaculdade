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
import sistema.uespi.modelo.DepartFunc;

/**
 *
 * @author Marquinhos
 */
public class DepartFuncDAO {

    private Connection conn;

    public DepartFuncDAO(Connection conn) {
        this.conn = conn;
    }

    public void addDepartFunc(DepartFunc df) {
        String sql = "UPDATE funcionario a inner join departamento b on a.idFunc =? "
                + "set a.id_depart = b.idDepart where b.idDepart = ?";
        
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, df.getFuncionario().getIdFunc());
            stmt.setLong(2, df.getDepartamento().getIdDepart());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionário Adicionado ao departamento!" , "Adicionado!", JOptionPane.INFORMATION_MESSAGE);
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alocar Funcionário", "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartFuncDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean isAlocado(DepartFunc df) {
        boolean existe = false;
        String sql = "SELECT id_depart, idFunc FROM funcionario WHERE id_depart=? and idFunc=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, df.getDepartamento().getIdDepart());
            stmt.setLong(2, df.getFuncionario().getIdFunc());
            rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(DepartFuncDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartFuncDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartFuncDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return existe;
    }

    public boolean nextAlocadoDao() {
        boolean existe = false;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM departamento";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if(rs.next()){
                existe = true;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartFuncDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartFuncDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DepartFuncDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return existe;
    }

}
