
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class VentanaEjemplo {

    
    public static void main(String[] args) {
       
        var ventana = new JFrame();
       
        ventana.setTitle("Hello Sam!");
        ventana.setSize(300, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        var layout = new BorderLayout();
        ventana.getContentPane().setLayout(layout);
        
        
       // var label = new JLabel("INTRODUCE TU NOMBRE");
       // ventana.getContentPane().add(label, BorderLayout.NORTH);
        
        var modelo = new DefaultListModel();
        var lista = new JList(modelo);
        
        ventana.getContentPane().add(lista);
        
        
       
        var texto = new JTextField();
        ventana.getContentPane().add(texto,BorderLayout.NORTH);
        
        var boton = new JButton("START");
        ventana.getContentPane().add(boton, BorderLayout.SOUTH);
        
        var manejador = (ActionListener) (ActionEvent e) -> {
           int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Añadir otro mas?",
                    "primer programa de swing", JOptionPane.OK_CANCEL_OPTION);
            if(showConfirmDialog == 0){
                modelo.addElement(texto.getText());
                
            }
            
        };
        
        boton.addActionListener(manejador);
        
        
        
        ventana.setVisible(true);
    }
    
}
