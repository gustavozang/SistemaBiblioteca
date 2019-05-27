/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Gustavo
 */
public class EditoraRelatorioDAO {
    public Connection conn;
    public JasperPrint relat;
    
    public EditoraRelatorioDAO(){
        conn = new ConnectionFactory().getConnection();
        
    }
    public JasperPrint gerar(){
        try{
            HashMap map = new HashMap();
            String arquivo = "ireport/RelatorioEditora.jasper";
            relat = JasperFillManager.fillReport(arquivo, map, conn);
        }catch(Exception erro){
            throw new RuntimeException(erro);
        }
        return relat;
    }
    
}
