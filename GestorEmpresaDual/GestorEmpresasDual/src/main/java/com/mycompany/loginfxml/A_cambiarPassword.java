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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import models.Alumno;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class A_cambiarPassword implements Initializable {

    @FXML
    private MenuItem btnCerrarSesion;
    @FXML
    private PasswordField txtPassword1;
    @FXML
    private PasswordField txtPassword2;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label info;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void CerrarSesion(ActionEvent event) {

        SessionData.setAlumno(null);
        try {
            App.setRoot("Login");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void cambiarPassword(ActionEvent event) {

        //se comprueba si hay coincidencia en las contraseñas //si es asi, se actualiza el usuario
        if (txtPassword1.getText().equals(txtPassword2.getText())) {

            SessionData.getAlumno().setPassword(txtPassword1.getText());
            SessionData.getAlumno().setLogin(Boolean.TRUE);
            Alumno alumno = new Alumno();
            alumno = SessionData.getAlumno();

            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
                Transaction t = s.beginTransaction();
                s.update(alumno);
                t.commit();

            }

            try {
                App.setRoot("A_listaActividades");
            } catch (IOException ex) {
                Logger.getLogger(A_cambiarPassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            info.setText("Las contraseñas no coinciden");
            info.setStyle("-fx-background-color:red; -fx-text-fill:white;");

        }

    }
}
