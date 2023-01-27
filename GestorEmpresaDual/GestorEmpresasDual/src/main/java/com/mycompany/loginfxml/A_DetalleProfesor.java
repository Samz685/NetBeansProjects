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
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Profesor;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class A_DetalleProfesor implements Initializable {

    @FXML
    private MenuItem btnCerrarSesion;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnCerrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        traerProfesor();

    }

    private void traerProfesor() {
        ArrayList<Profesor> profesores = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Conexión realizada con éxito");

            Query q = s.createQuery("from Profesor where id=" + SessionData.getProfesor().getId());
            profesores = (ArrayList<Profesor>) q.list();
            s.close();
        }

        for (Profesor p : profesores) {

            txtNombre.setText(p.getNombre());
            txtApellidos.setText(p.getApellidos());
            txtEmail.setText(p.getEmail());

        }

    }

    private void Volver(ActionEvent event) {
        try {
            App.setRoot("A_listaActividades");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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

}
