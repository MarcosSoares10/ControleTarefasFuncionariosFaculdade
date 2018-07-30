/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.controle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.uespi.conexaobanco.ConexaoFactory;
import sistema.uespi.dao.ContaDAO;
import sistema.uespi.modelo.Conta;

/**
 *
 * @author Marquinhos
 */
public class ContaCtrl {

    private Connection conn;

    public ContaCtrl() {
        this.conn = new ConexaoFactory().getConexao();
    }

    public void salvarConta(Conta c) {
        ContaDAO daoc = new ContaDAO(conn);
        if (daoc.isIdConta(c) == false) {
            if (daoc.isEmailConta(c) == false) {
                daoc.addConta(c);
                
            } else {
                JOptionPane.showMessageDialog(null, "E-mail já cadastrado", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Fucinário já possui conta de acesso.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Conta getContaAcesso(Conta c) {
        ContaDAO daoc = new ContaDAO(conn);
        Conta conta = daoc.getContaAcesso(c);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conta;
    }
    
    public void updateconta(Long id,String retorno){
    ContaDAO daoc = new ContaDAO(conn);
        daoc.update(id,retorno);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}
