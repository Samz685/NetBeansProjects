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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Empresa;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class P_crearEmpresa implements Initializable {

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
    private Button btnCancelar;
    @FXML
    private Button btnCrear;
    @FXML
    private Label info;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void crearEmpresa(ActionEvent event) {

        Empresa e = leerFormulario();

        if (e != null) {

            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
                Transaction t = s.beginTransaction();
                s.save(e);
                t.commit();

                try {
                    App.setRoot("P_listaEmpresas");
                } catch (IOException ex) {
                    Logger.getLogger(P_crear_Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    private Empresa leerFormulario() {

        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String responsable = txtResponsable.getText();
        String observaciones = txtObservaciones.getText();

        if ("".equals(nombre) || "".equals(telefono) || "".equals(email) || responsable == null
                || "".equals(observaciones)) {

            info.setText("Faltan Datos");
            info.setStyle("-fx-background-color:red; -fx-text-fill:white;");
            return null;

        } else {
            Empresa e = new Empresa();

            e.setNombre(nombre);
            e.setTelefono(telefono);
            e.setEmail(email);
            e.setResponsable(responsable);
            e.setObservaciones(observaciones);

            return e;
        }
    }

    @FXML
    private void Volver(ActionEvent event) {
        try {
            App.setRoot("P_crearNuevo");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
