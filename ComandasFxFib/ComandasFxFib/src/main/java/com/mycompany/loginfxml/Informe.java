
package com.mycompany.loginfxml;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.swing.JRViewer;
import org.hibernate.Session;


public class Informe {

    public static void showReport() throws JRException, ClassNotFoundException, SQLException {

        HashMap hm = new HashMap();
        
        String report = "Reporte Carta.jasper";
        

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                null, 
                JdbcUtil.getConnection()
        );

        JRViewer viewer = new JRViewer(jasperPrint);

        JFrame frame = new JFrame("Listado de Productos");
        frame.getContentPane().add(viewer);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

        System.out.print("Done!");
    }

    public static void pdfReport(String tipo) throws JRException, ClassNotFoundException, SQLException {

//        HashMap hm = new HashMap();
//
//        hm.put("tipo", tipo);
//
//        String report = "Pokemon.jasper";
//
//        JasperPrint jasperPrint = JasperFillManager.fillReport(
//                report, 
//                hm, 
//                HibernateUtil.getSessionFactory()
//        );
//        
//        JRPdfExporter exp = new JRPdfExporter();
//        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
//        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("pokeball.pdf"));
//        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
//        exp.setConfiguration(conf);
//        exp.exportReport();
//
//        System.out.print("Done!");
    }

}
