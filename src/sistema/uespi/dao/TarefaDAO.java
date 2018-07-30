/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.uespi.modelo.Departamento;
import sistema.uespi.modelo.Tarefa;
import sistema.uespi.util.FormattData;

/**
 *
 * @author Marquinhos
 */
public class TarefaDAO {
    
    private Connection conn;
    private static List<Tarefa> list = new ArrayList<Tarefa>();
    
    public TarefaDAO(Connection con){
        this.conn = con;
       
    }
   
  
  
    public void adicionatarefa(Tarefa f){
        PreparedStatement stmfunc=null,stmbusca=null,stmend=null;
        ResultSet rs = null;
        
        try {
            String sql = "INSERT INTO tarefa (descricao, assunto, dataInicio,dataFinal,estado_tarefa,func_id,depart) VALUES (?,?,?,?,?,?,?)";
           
            stmfunc = conn.prepareStatement(sql);
            stmfunc.setString(1, f.getDescricao());
            stmfunc.setString(2, f.getAssunto());
            stmfunc.setDate(3,new FormattData().dataSql(f.getDatainicio()));
            stmfunc.setDate(4,new FormattData().dataSql(f.getDatafinal()));
            stmfunc.setString(5, f.getEstado_tarefa());
            stmfunc.setLong(6, f.getFunc_id());
            stmfunc.setLong(7, f.getDepart());
            stmfunc.execute();
           
            JOptionPane.showMessageDialog(null, "Tarefa Cadastrada", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
               } catch (SQLException  e) {
                   e.printStackTrace();
        }
    }
 
    public void updatetarefa(Tarefa f){
        String sql = "UPDATE tarefa SET assunto=?,descricao=?,dataInicio=?,dataFinal=?,estado_tarefa=? where idTarefa=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, f.getAssunto());
            stmt.setString(2, f.getDescricao());
            stmt.setDate(3, new FormattData().dataSql(f.getDatainicio()));
            stmt.setDate(4, new FormattData().dataSql(f.getDatafinal()));
            stmt.setLong(6, f.getIdTarefa());
            stmt.setString(5, f.getEstado_tarefa());
            stmt.execute();
            stmt.close();
             JOptionPane.showMessageDialog(null, "Tarefa Alterada", "Alteração", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
        }
    
    }
    public List<Tarefa> listtarefaDao(Long d) {
        List<Tarefa> tarefas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT distinct idTarefa,assunto,dataInicio,dataFinal,depart,estado_tarefa,descricao,nomeDepart,func_id FROM tarefa INNER JOIN departamento ON depart = idDepart where idDepart = ?";
        try {
            
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, d);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Tarefa t = new Tarefa();
                t.setIdTarefa(rs.getLong("idTarefa"));
                t.setAssunto(rs.getString("assunto"));
                t.setDescricao(rs.getString("descricao"));
                t.setDatainicio(rs.getDate("dataInicio"));
                t.setDatafinal(rs.getDate("dataFinal"));
                t.setDepart(rs.getLong("depart"));
                t.setFunc_id(rs.getLong("func_id"));
                t.setNomeDepart(rs.getString("nomeDepart"));
                t.setEstado_tarefa(rs.getString("estado_tarefa"));
                tarefas.add(t);
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
                    Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return tarefas;
    }
    
    public List<Tarefa> listtarefaadm(){
    
    List<Tarefa> tarefas_tudo = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT distinct idTarefa,assunto,dataInicio,dataFinal,depart,estado_tarefa,descricao,nomeDepart,func_id FROM tarefa INNER JOIN departamento ON depart = idDepart";
       
        try {
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Tarefa todos = new Tarefa();
                todos.setIdTarefa(rs.getLong("idTarefa"));
                todos.setAssunto(rs.getString("assunto"));
                todos.setDescricao(rs.getString("descricao"));
                todos.setDatainicio(rs.getDate("dataInicio"));
                todos.setDatafinal(rs.getDate("dataFinal"));
                todos.setNomeDepart(rs.getString("nomeDepart"));
                todos.setFunc_id(rs.getLong("func_id"));
                todos.setEstado_tarefa(rs.getString("estado_tarefa"));
                tarefas_tudo.add(todos);
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
                    Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return tarefas_tudo;
    }
     
    
    
}
