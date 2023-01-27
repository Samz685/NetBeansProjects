package com.mycompany.loginfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class P_crearNuevo implements Initializable {

    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnCerrar1;
    @FXML
    private Button btnCerrar2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void irAlumno(ActionEvent event) {

        try {
            App.setRoot("P_crear_Alumno");
        } catch (IOException ex) {
            Logger.getLogger(P_crearNuevo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void irEmpresa(ActionEvent event) {

        try {
            App.setRoot("P_crearEmpresa");
        } catch (IOException ex) {
            Logger.getLogger(P_crearNuevo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void irListaAlumnos(ActionEvent event) {

        try {
            App.setRoot("P_listaAlumnos");
        } catch (IOException ex) {
            Logger.getLogger(P_crearNuevo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
