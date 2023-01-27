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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Empresa;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class A_DetalleEmpresa implements Initializable {

    @FXML
    private MenuItem btnCerrarSesion;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtResponsable;
    @FXML
    private TextArea txtObservaciones;
    @FXML
    private Button btnCerrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        traerEmpresa();
    }

    private void traerEmpresa() {

        ArrayList<Empresa> empresas = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Conexión realizada con éxito");

            Query q = s.createQuery("from Empresa where id=" + SessionData.getEmpresa().getId());
            empresas = (ArrayList<Empresa>) q.list();
            s.close();
        }

        for (Empresa p : empresas) {

            txtNombre.setText(p.getNombre());
            txtTelefono.setText(p.getTelefono());
            txtEmail.setText(p.getEmail());
            txtResponsable.setText(p.getResponsable());
            txtObservaciones.setText(p.getObservaciones());

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
