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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Empresa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class P_modificarEmpresa implements Initializable {

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
    private Label info;
    @FXML
    private Button btnAceptar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        traerEmpresa();

    }

    @FXML
    private void modificarEmpresa(ActionEvent event) {

        SessionData.getEmpresa().setNombre(txtNombre.getText());
        SessionData.getEmpresa().setTelefono(txtTelefono.getText());
        SessionData.getEmpresa().setEmail(txtEmail.getText());
        SessionData.getEmpresa().setResponsable(txtResponsable.getText());
        SessionData.getEmpresa().setObservaciones(txtObservaciones.getText());

        Empresa e = new Empresa();
        e = SessionData.getEmpresa();

        if (e != null) {

            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
                Transaction t = s.beginTransaction();
                s.update(e);
                t.commit();

                try {
                    App.setRoot("P_listaEmpresas");
                } catch (IOException ex) {
                    Logger.getLogger(P_crear_Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
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
    private void Volver(ActionEvent event) {
        try {
            App.setRoot("P_listaEmpresas");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
