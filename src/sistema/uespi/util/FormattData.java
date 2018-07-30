/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marquinhos
 */
public class FormattData {

    public Date dataStrForDate(String data) {
        Date dataf = null;
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            dataf = format.parse(data);
            return dataf;
        } catch (ParseException ex) {
            Logger.getLogger(FormattData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataf;
    }
    
   

    public String dataForString(Date data) {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataConvert = format.format(data);
        return dataConvert;
    }

    public java.sql.Date dataSql(java.util.Date data) {
        java.sql.Date sqlDate = new java.sql.Date(data.getTime());
        return sqlDate;
    }
}
