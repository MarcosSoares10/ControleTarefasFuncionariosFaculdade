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
import sistema.uespi.conexaobanco.ConexaoFactory;
import sistema.uespi.dao.TarefaDAO;
import sistema.uespi.modelo.Departamento;
import sistema.uespi.modelo.Tarefa;

/**
 *
 * @author Marquinhos
 */
public class TarefaCtrl {
    private Connection conn;
    
    public TarefaCtrl(){
    this.conn = new ConexaoFactory().getConexao();
    }
    
    public List<Tarefa> listtarefa(Long d) {
      
       TarefaDAO daotarefa = new TarefaDAO(conn);
        List<Tarefa>list = daotarefa.listtarefaDao(d);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Tarefa> listtudo(){
     TarefaDAO daotarefa = new TarefaDAO(conn);
     List<Tarefa> lista_tudo = daotarefa.listtarefaadm();
        try {
           conn.close(); 
        } catch (Exception e) {
        }
        return lista_tudo;
}
    
    
    public void salvarTarefa(Tarefa a){
    TarefaDAO tarefadao = new TarefaDAO(conn);
        try {
            tarefadao.adicionatarefa(a);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarefaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void updateTarefa(Tarefa u){
    TarefaDAO tarefadao = new TarefaDAO(conn);
        try {
            tarefadao.updatetarefa(u);
        } catch (Exception e) {
        }
    }
    
   
}
