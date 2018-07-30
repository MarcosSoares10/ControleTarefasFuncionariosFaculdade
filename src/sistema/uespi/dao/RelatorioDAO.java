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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.uespi.modelo.Relatorio;

/**
 *
 * @author Marquinhos
 */
public class RelatorioDAO {  
    
     private Connection con;
     

    public RelatorioDAO(Connection conn) {
    this.con = conn;
   }
    
     public List<Relatorio> listtarefaadm() throws SQLException{
    
         List<Relatorio> tarefas_tudo = new ArrayList<>();
      
  
        PreparedStatement stmt = null;
        String sql = "SELECT distinct assunto,dataInicio,dataFinal,estado_tarefa,nomeDepart "
                + "FROM tarefa INNER JOIN departamento ON depart = idDepart";
    try {
            
            stmt = con.prepareStatement(sql);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            while (rs.next()) {
                Relatorio todos = new Relatorio();
                todos.setAssunto(rs.getString("assunto"));
                todos.setEstado_tarefa(rs.getString("estado_tarefa"));
                todos.setDataInicio(rs.getDate("dataInicio"));
                todos.setDataFinal(rs.getDate("dataFinal"));
                todos.setNomeDepart(rs.getString("nomeDepart"));
               
     ;
                tarefas_tudo.add(todos);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
        return tarefas_tudo;
    }
     
      public List<Relatorio> listtarefager(Long d) throws SQLException{
    
         List<Relatorio> tarefas_tudo = new ArrayList<>();
      
  
        PreparedStatement stmt = null;
        String sql = "SELECT distinct assunto,dataInicio,dataFinal,estado_tarefa,nomeDepart FROM tarefa INNER JOIN departamento ON depart = idDepart where idDepart = ?";
        
        try {
            
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, d);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            while (rs.next()) {
                Relatorio todos = new Relatorio();
                todos.setAssunto(rs.getString("assunto"));
                todos.setEstado_tarefa(rs.getString("estado_tarefa"));
                todos.setDataInicio(rs.getDate("dataInicio"));
                todos.setDataFinal(rs.getDate("dataFinal"));
                todos.setNomeDepart(rs.getString("nomeDepart"));
                tarefas_tudo.add(todos);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
        return tarefas_tudo;
    }

   
}
