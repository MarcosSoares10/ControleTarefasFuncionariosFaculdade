/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.util;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Marquinhos
 */
public class Mascaras {
    
    public void mascararTelefone(JFormattedTextField textTelefone){
        try{
            new MaskFormatter("(##) #####-####").install(textTelefone);
        }catch(ParseException ex){
            ex.printStackTrace();
        }
    }
    
    
    public void mascararCpf(JFormattedTextField cpf){
        try{
            new MaskFormatter("###.###.###-##").install(cpf);
        }catch(ParseException ex){
            ex.printStackTrace();
        }
    }
    
    
}
