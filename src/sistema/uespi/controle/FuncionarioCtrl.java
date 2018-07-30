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
import sistema.uespi.dao.FuncionarioDAO;
import sistema.uespi.modelo.Endereco;
import sistema.uespi.modelo.Funcionario;

/**
 *
 * @author Marquinhos
 */
public class FuncionarioCtrl {

    private Connection conn;

    public FuncionarioCtrl() {
        this.conn = new ConexaoFactory().getConexao();
    }

    public void salvarFuncionario(Funcionario f) {
        FuncionarioDAO daoFunc = new FuncionarioDAO(conn);
        if (daoFunc.isCpfDao(f) == false) {
            daoFunc.addFuncionarioDao(f);
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário já possui registro", "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isCpf(Funcionario f) {
        FuncionarioDAO daoFunc = new FuncionarioDAO(conn);
        boolean existe = daoFunc.isCpfDao(f);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }

    public Funcionario getFuncionarioViaCpf(Funcionario f) {
        FuncionarioDAO daoFunc = new FuncionarioDAO(conn);
        Funcionario funcionario = daoFunc.getFuncionarioViaCpfDao(f);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    public Funcionario getFuncionarioViaId(Funcionario f) {
        FuncionarioDAO daoFunc = new FuncionarioDAO(conn);
        Funcionario funcionario = daoFunc.getFuncionarioViaIdDao(f);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }
    
    public void updateFuncionario(Long id,String retorno){
        FuncionarioDAO daoFunc = new FuncionarioDAO(conn);
       daoFunc.updateFuncionario(id,retorno);
    try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
  

   public Boolean gerente(Funcionario f){
       //FuncionarioDAO daofunc = new FuncionarioDAO(conn);
       //boolean existe = daofunc.gerente(f);
       System.out.println(f.getIdFunc());
       return true;
       
   }

    
    
  

}
