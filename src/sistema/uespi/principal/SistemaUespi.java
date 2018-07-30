/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.principal;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.jvnet.substance.skin.SubstanceBusinessLookAndFeel;
import org.jvnet.substance.skin.SubstanceDustLookAndFeel;
import sistema.uespi.controle.DepartFuncCtrl;
import sistema.uespi.controle.DepartamentoCtrl;
import sistema.uespi.controle.FuncionarioCtrl;
import sistema.uespi.relatorio.RelatorioPdf;
import sistema.uespi.view.FrmAlocarFuncionario;
import sistema.uespi.view.FrmCadastrarDepartamento;
import sistema.uespi.view.FrmCadastrarFuncionario;
import sistema.uespi.view.FrmLogin;

/**
 *
 * @author Marquinhos
 */
public class SistemaUespi {

    public static void main(String[] args) throws DocumentException, FileNotFoundException, BadElementException, IOException, SQLException {
       /* DepartamentoCtrl dc = new DepartamentoCtrl();
        
        if(!dc.nextDepartamento()){
            FrmCadastrarDepartamento fcd = new FrmCadastrarDepartamento(null, true);
            fcd.setVisible(true);
            
        }
        
        FuncionarioCtrl fc = new FuncionarioCtrl();
        if(!fc.nextFuncionario()){
            FrmCadastrarFuncionario fcf = new FrmCadastrarFuncionario(null, true);
            fcf.setVisible(true);
           
        }
        
        DepartFuncCtrl dfc = new DepartFuncCtrl();
        if(!dfc.nextAlocado()){
            FrmAlocarFuncionario faf = new FrmAlocarFuncionario(null, true);
            faf.setVisible(true);
        }*/
       
        JFrame.setDefaultLookAndFeelDecorated(true);
        
         
        SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
            try {
            //  UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());
               UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());
            // UIManager.setLookAndFeel(new SubstanceDustLookAndFeel());
             FrmLogin frmLogin = new FrmLogin(null, true);
             frmLogin.setVisible(true);
            } catch (Exception e) {
              System.out.println("Substance Raven Graphite failed to initialize");
            }
           }     
        });
                

}
}
