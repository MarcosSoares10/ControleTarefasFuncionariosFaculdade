/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.controle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.uespi.conexaobanco.ConexaoFactory;
import sistema.uespi.dao.DepartamentoDAO;
import sistema.uespi.modelo.Departamento;
import sistema.uespi.modelo.Funcionario;

/**
 *
 * @author Marquinhos
 */
public class DepartamentoCtrl {

    private Connection conn;

    public DepartamentoCtrl() {
        this.conn = new ConexaoFactory().getConexao();
    }

    public void salvarDepartamento(Departamento d) {
        DepartamentoDAO daoDepart = new DepartamentoDAO(conn);

        if (daoDepart.isDepartamentoDao(d) == false) {
            daoDepart.addDepartamentoDao(d);
        } else {
            JOptionPane.showMessageDialog(null, "Departamento já possui registro", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Departamento> listDepart() {
        DepartamentoDAO daoDepart = new DepartamentoDAO(conn);
        List<Departamento> list = daoDepart.listDepartDao();
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   
    public Departamento nextDepartamento(Departamento d){
        DepartamentoDAO daoDepart = new DepartamentoDAO(conn);
        Departamento existe  = daoDepart.returnDepartamentoDao(d);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;        
    }
    
    public Boolean gerente(Funcionario f){
        DepartamentoDAO daoDepart = new DepartamentoDAO(conn);
        boolean existe = daoDepart.gerente(f);
        
    return existe;
    
    }
    
    

}
