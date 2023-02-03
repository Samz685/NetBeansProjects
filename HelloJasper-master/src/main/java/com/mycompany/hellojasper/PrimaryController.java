package com.mycompany.hellojasper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.JRException;

public class PrimaryController {

    @FXML
    private Button primaryButton;
    @FXML
    private TextField tipo;

    @FXML
    private void verInforme(ActionEvent event) {
        try {
            Informe.showReport( tipo.getText() );
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Informe.pdfReport( tipo.getText() );
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
