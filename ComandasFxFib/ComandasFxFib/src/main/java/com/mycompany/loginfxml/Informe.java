
package com.mycompany.loginfxml;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.swing.JRViewer;


public class Informe {

    public static void showReportCarta() throws JRException, ClassNotFoundException, SQLException {

        String report = "Reporte_Carta.jasper";

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
        frame.setSize(800, 1000);
        frame.setVisible(true);

        System.out.print("Done!");
    }

    public static void pdfReportCarta() throws JRException, ClassNotFoundException, SQLException {

        String report = "Reporte_Carta.jasper";

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                null, 
                JdbcUtil.getConnection()
        );
        
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reporte_Carta.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();

        System.out.print("Done!");
    }
    
    public static void showReportPedidosHoy(Date fecha) throws JRException, ClassNotFoundException, SQLException {


        String report = "ReportePedidosHoy.jasper";
        HashMap hm = new HashMap();

        hm.put("fechaParam", fecha);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
                JdbcUtil.getConnection()
        );

        JRViewer viewer = new JRViewer(jasperPrint);

        JFrame frame = new JFrame("Comandas");
        frame.getContentPane().add(viewer);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setSize(800, 1000);
        frame.setVisible(true);

        System.out.print("Done!");
    }
    
    public static void pdfReportPedidosHoy(Date fecha) throws JRException, ClassNotFoundException, SQLException {

        String report = "ReportePedidosHoy.jasper";
        HashMap hm = new HashMap();
        hm.put("fechaParam", fecha);

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
                JdbcUtil.getConnection()
        );
        
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reporte_Pedidos_Hoy.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();

        System.out.print("Done!");
    }
    
    public static void showReportPedidosPeriodo(Date fecha1, Date fecha2) throws JRException, ClassNotFoundException, SQLException {


        String report = "ReportePedidosPeriodo.jasper";
        HashMap hm = new HashMap();

        hm.put("fechaParam", fecha1);
        hm.put("fechaParam2", fecha2);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
                JdbcUtil.getConnection()
        );

        JRViewer viewer = new JRViewer(jasperPrint);

        JFrame frame = new JFrame("Reporte Comandas Periodo");
        frame.getContentPane().add(viewer);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setSize(800, 1000);
        frame.setVisible(true);

        System.out.print("Done!");
    }
    
    public static void pdfReportPedidosPeriodo(Date fecha1, Date fecha2) throws JRException, ClassNotFoundException, SQLException {

        String report = "ReportePedidosPeriodo.jasper";
        HashMap hm = new HashMap();
        hm.put("fechaParam", fecha1);
        hm.put("fechaParam2", fecha2);

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report, 
                hm, 
                JdbcUtil.getConnection()
        );
        
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reporte_Pedidos_Periodo.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();

        System.out.print("Done!");
    }

}
