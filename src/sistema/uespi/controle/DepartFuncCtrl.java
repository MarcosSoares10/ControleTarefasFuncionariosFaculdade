/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.uespi.conexaobanco.ConexaoFactory;
import sistema.uespi.dao.DepartFuncDAO;
import sistema.uespi.modelo.DepartFunc;
import sistema.uespi.modelo.Funcionario;

/**
 *
 * @author Marquinhos
 */
public class DepartFuncCtrl {

    private Connection conn;

    public DepartFuncCtrl() {
        this.conn = new ConexaoFactory().getConexao();
    }

    public void salvarDepartFunc(DepartFunc df) {
        DepartFuncDAO daoDf = new DepartFuncDAO(conn);
     
        
        if (daoDf.isAlocado(df) == false) {
            daoDf.addDepartFunc(df);
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário já está alocado.\nVocê pode fazer apenas alterações.", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartFuncCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean nextAlocado() {
        DepartFuncDAO daoDf = new DepartFuncDAO(conn);
        boolean existe = daoDf.nextAlocadoDao();
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartFuncCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    public void pesquisadepart(Funcionario funcionario){
    DepartFuncDAO departfuncdao = new DepartFuncDAO(conn);
    
    }
}
