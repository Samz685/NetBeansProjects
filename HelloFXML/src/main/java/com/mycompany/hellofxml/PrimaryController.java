package com.mycompany.hellofxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable{

    @FXML
    private Button primaryButton;
    @FXML
    private Label salida;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private TextField cajetin;
    @FXML
    private Button btnAñadir;

    @FXML
    private void switchToSecondary() throws IOException {
        String persona = combo.getSelectionModel().getSelectedItem();
        salida.setText("Hola "+persona);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.getItems().add("Alejandro");
        combo.getItems().add("Luis");
        
        ObservableList<String> lista = combo.getItems();
        
        ArrayList<String> l = new ArrayList<String>();
        l.add("Francisco");
        l.add("Guillermo");
        lista.addAll(l);
        
        l.add("Adolfo");
        lista.addAll(l);
        
        combo.getItems().clear();
        
        lista.add("Jose Antonio");
        
        combo.getSelectionModel().selectFirst();
        
    }

    @FXML
    private void añadirNombre(ActionEvent event) {
       
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Saludador");
        alert.setContentText("HOLA "+ cajetin.getText());
        alert.showAndWait();
        
        System.out.println(alert.getResult().getText());
        if( "Aceptar".equals(alert.getResult().getText()) ){
            combo.getItems().add( cajetin.getText() );            
        }
        
    }
}
