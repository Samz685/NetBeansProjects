package com.mycompany.loginfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Alumno;
import models.Profesor;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Login implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnAceptar;
    @FXML
    private CheckBox chkSesion;
    @FXML
    private Label info;

    @FXML
    private void cancelar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void aceptar(ActionEvent event) {

        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {

            //usuario profesor
            Query qProfe = s.createQuery("from Profesor where nombre=:param and password=:pwd");
            qProfe.setParameter("param", txtUser.getText());
            qProfe.setParameter("pwd", txtPassword.getText());

            ArrayList<Profesor> resultadoProfe = (ArrayList<Profesor>) qProfe.list();

            //usuario alumno
            Query qAlumno = s.createQuery("from Alumno where nombre=:param and password=:pwd");
            qAlumno.setParameter("param", txtUser.getText());
            qAlumno.setParameter("pwd", txtPassword.getText());

            ArrayList<Alumno> resultadoAlumno = (ArrayList<Alumno>) qAlumno.list();

            //comprobamos si el resultado está en la tabla profesor o alumno
            if (!resultadoProfe.isEmpty() || !resultadoAlumno.isEmpty()) {
                info.setText("Usuario existe");
                info.setStyle("-fx-background-color:green; -fx-text-fill:white;");

                if (!resultadoProfe.isEmpty()) {
                    SessionData.setProfesor(resultadoProfe.get(0));

                    try {
                        App.setRoot("Bienvenida");
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (!resultadoAlumno.isEmpty()) {

                    SessionData.setAlumno(resultadoAlumno.get(0));

                    //si es alumno y es su primer login, lo llevamos a la pantalla cambiar Password
                    try {
                        if (SessionData.getAlumno().getLogin() == false) {
                            App.setRoot("A_cambiarPassword");
                        } else {
                            App.setRoot("Bienvenida");
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } else {
                info.setText("Usuario no existe");
                info.setStyle("-fx-background-color:red; -fx-text-fill:white;");
            }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
//            System.out.println("Conexión realizada con éxito");
//        }
    }

}
