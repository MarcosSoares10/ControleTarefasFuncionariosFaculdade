/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.controle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import sistema.uespi.conexaobanco.ConexaoFactory;
import sistema.uespi.dao.RelatorioDAO;
import sistema.uespi.modelo.Relatorio;

/**
 *
 * @author Marquinhos
 */
public class RelatorioCtrl {
     private Connection conn;
    
    public RelatorioCtrl(){
    this.conn = new ConexaoFactory().getConexao();
    }
     public List<Relatorio> listtudo() throws SQLException{
     RelatorioDAO daorelatorio = new RelatorioDAO(conn);
     List<Relatorio> lista_tudo = daorelatorio.listtarefaadm();
    
        try {
            
            
          // conn.close(); 
        } catch (Exception e) {
        }
        return lista_tudo;
}
     public List<Relatorio> listtudoger(long d) throws SQLException{
     RelatorioDAO daorelatorio = new RelatorioDAO(conn);
     List<Relatorio> lista_tudo = daorelatorio.listtarefager(d);
    
        try {
            
            
          // conn.close(); 
        } catch (Exception e) {
        }
        return lista_tudo;
}
    
}
