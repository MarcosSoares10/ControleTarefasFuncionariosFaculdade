/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.uespi.relatorio;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sistema.uespi.controle.RelatorioCtrl;
import sistema.uespi.controle.TarefaCtrl;
import sistema.uespi.modelo.Funcionario;
import sistema.uespi.modelo.Relatorio;
import sistema.uespi.modelo.Tarefa;
import sistema.uespi.tabelamodelo.Tarefatablemodel;


import sun.rmi.log.LogOutputStream;



/**
 *
 * @author Marquinhos
 */
public class RelatorioPdf {
    private JFileChooser Seletor_Arquivo;
    String Caminho_Arquivo;
    Document documento;
   
 
    private static Font fonteCabecalho = new Font(Font.FontFamily.COURIER, 14,Font.BOLD);
	private static Font fontePadrao = new Font(Font.FontFamily.TIMES_ROMAN, 12);
	private static Font fonteVermelha = new Font(Font.FontFamily.TIMES_ROMAN,
			12, Font.NORMAL, BaseColor.RED);
	private static Font negritoPequena = new Font(Font.FontFamily.HELVETICA,
			7, Font.BOLD);

    
public void relatorioadm() throws DocumentException, FileNotFoundException, BadElementException, IOException, SQLException{
   RelatorioCtrl relatorio = new RelatorioCtrl();
   
   
    Image image1 = Image.getInstance("logo-uespi.png");
       
        
    
    
    try {
        
        documento = new Document();
        documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento,new FileOutputStream("RelatorioAdministrador.pdf"));
        documento.open();
  	Paragraph conteudo = new Paragraph();
        documento.add(image1);
        conteudo.add(new Paragraph("Atividades Exercidas durante a Jornada de Trabalho", fonteCabecalho));
         conteudo.add(new Paragraph("Relatório Completo"));
        conteudo.add(new Paragraph(" "));
                  Chapter capitulo = new Chapter(new Paragraph(""),1);
                Paragraph novoParagrafo = new Paragraph("",
					negritoPequena);
               Section secao = capitulo.addSection(novoParagrafo);
               PdfPTable table = new PdfPTable(5);
            
                        PdfPCell c1;
                      
			c1 = new PdfPCell(new Phrase("Tarefa"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			c1 = new PdfPCell(new Phrase("Departamento"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
                        c1 = new PdfPCell(new Phrase("Data de Inicio"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
                        c1 = new PdfPCell(new Phrase("Prazo Final"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
                        c1 = new PdfPCell(new Phrase("Estado da Tarefa"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
                         
                        for(Relatorio result:relatorio.listtudo()){
                            table.addCell(result.getAssunto());
                            table.addCell(result.getNomeDepart());
                            table.addCell(String.valueOf(result.getDataInicio()));
                            table.addCell(String.valueOf(result.getDataFinal()));
                            table.addCell(result.getEstado_tarefa());
                         }
      
                 secao.add(table);
            
                        
                    
                documento.add(conteudo);
                documento.add(secao);
                documento.close();
        
        JOptionPane.showMessageDialog(null, "Relatório Completo Criado", "Aviso!", JOptionPane.ERROR_MESSAGE);
           
			
    } catch (Exception e) {
        e.printStackTrace();
    }

}

public void relatorioger(Funcionario f) throws DocumentException, FileNotFoundException, BadElementException, IOException, SQLException{
   RelatorioCtrl relatorio = new RelatorioCtrl();
   Funcionario funcionario = f;
   
    Image image1 = Image.getInstance("logo-uespi.png");
       
        
    
    
    try {   
        documento = new Document();
        documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento,new FileOutputStream("RelatorioGerente.pdf"));
        documento.open();
  	Paragraph conteudo = new Paragraph();
        documento.add(image1);
        conteudo.add(new Paragraph("Atividades Exercidas durante a Jornada de Trabalho", fonteCabecalho));
        conteudo.add(new Paragraph("Relatório do Departamento"));
        conteudo.add(new Paragraph(" "));
    
                Chapter capitulo = new Chapter(new Paragraph(""),1);
                Paragraph novoParagrafo = new Paragraph("",
					negritoPequena);
               Section secao = capitulo.addSection(novoParagrafo);
               PdfPTable table = new PdfPTable(5);
            
                        PdfPCell c1;
                       
                        
			c1 = new PdfPCell(new Phrase("Tarefa"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			c1 = new PdfPCell(new Phrase("Departamento"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
                        c1 = new PdfPCell(new Phrase("Data de Inicio"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
                        c1 = new PdfPCell(new Phrase("Prazo Final"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
                        c1 = new PdfPCell(new Phrase("Estado da Tarefa"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
                         
                        for(Relatorio result:relatorio.listtudoger(funcionario.getId_depart())){
                            table.addCell(result.getAssunto());
                            table.addCell(result.getNomeDepart());
                            table.addCell(String.valueOf(result.getDataInicio()));
                            table.addCell(String.valueOf(result.getDataFinal()));
                            table.addCell(result.getEstado_tarefa());
                         }
                  
               
                

                 secao.add(table);
            
                        
                    
                documento.add(conteudo);
                documento.add(secao);
                documento.close();
      JOptionPane.showMessageDialog(null, "Relatório do Gerente Criado", "Aviso!", JOptionPane.ERROR_MESSAGE);
          
        
			
    } catch (Exception e) {
        e.printStackTrace();
    }

}

   
}
