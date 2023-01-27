package com.mycompany.loginfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Bienvenida implements Initializable {

    @FXML
    private Button btnAceptar;
    @FXML
    private Text txtBien;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        saludo();

        if (SessionData.getProfesor() != null) {
            System.out.println(SessionData.getProfesor().getNombre());
        } else if (SessionData.getAlumno() != null) {

            System.out.println(SessionData.getAlumno().getNombre());
        }
    }



    private void saludo() {

        if (SessionData.getProfesor() != null) {
            txtBien.setText("Bienvenido/a Profesor " + SessionData.getProfesor().getNombre());
        } else if (SessionData.getAlumno()!= null){

            txtBien.setText("Bienvenido/a Alumno " + SessionData.getAlumno().getNombre());
        }

    }

    private void cerrarVentana(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void aceptar(ActionEvent event) {

        if (SessionData.getProfesor() != null) {

            try {
                App.setRoot("P_listaAlumnos");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                App.setRoot("A_listaActividades");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
