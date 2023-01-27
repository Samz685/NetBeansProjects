package com.mycompany.loginfxml;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.StringConverter;
import models.Alumno;
import models.Empresa;
import models.Profesor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class P_crear_Alumno implements Initializable {

    @FXML
    private Button btnAñadir;
    @FXML
    private MenuItem menuSalir;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtDual;
    @FXML
    private TextField txtFct;
    @FXML
    private DatePicker txtFecha;
    @FXML
    private TextField txttelefono;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnVolver;
    @FXML
    private ComboBox<Empresa> comboEmpresa;

    private Alumno alumnoActual = null;
    @FXML
    private Label info;
    @FXML
    private RadioButton radioFct;
    @FXML
    private ToggleGroup Modalidad;
    @FXML
    private RadioButton radioDual;
    @FXML
    private TextField txtPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        llenarCombo();
        txtDual.setDisable(true);
        txtFct.setDisable(true);
        txtDual.setText("0");
        txtFct.setText("0");

    }

    private Alumno leerFormulario() {

        //fecha datapicker
        LocalDate fecha = txtFecha.getValue();

        int dual = Integer.parseInt(txtDual.getText());
        int fct = Integer.parseInt(txtFct.getText());
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String dni = txtDni.getText();
        String email = txtEmail.getText();
        String telefono = txttelefono.getText();
        String password = txtPassword.getText();
        Empresa empresa = comboEmpresa.getValue();
        Profesor tutor = SessionData.getProfesor();
        String tipo = null;
        //tipo practica
        if (radioDual.isSelected()) {
            tipo = "DUAL";
        } else {
            tipo = "FCT";
        }

        if ("".equals(nombre) || "".equals(apellidos) || "".equals(dni) || empresa == null
                || "".equals(email) || "".equals(password) || "".equals(telefono) || dual == 0 && fct == 0) {
            info.setText("Faltan Datos");
            info.setStyle("-fx-background-color:red; -fx-text-fill:white;");
            return null;
        } else {
            Alumno a = new Alumno();

            a.setNombre(nombre);
            a.setApellidos(apellidos);
            a.setDni(dni);
            a.setEmail(email);
            a.setTelefono(telefono);
            a.setPassword(password);
            a.setFecha_nac(fecha);
            a.setEmpresa(empresa);
            a.setProfesor(tutor);
            a.setHoras_dual(dual);
            a.setHoras_fct(fct);
            a.setTipo(tipo);
            a.setLogin(false);
            return a;
        }
    }

    public ArrayList<Empresa> traerEmpresas() {
        ArrayList<Empresa> empresas = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("from Empresa");
            empresas = (ArrayList<Empresa>) q.list();
        }

        return empresas;

    }

    public void llenarCombo() {

        ObservableList<Empresa> empresas = FXCollections.observableArrayList();

        for (Empresa p : traerEmpresas()) {
            empresas.add(p);

        }
        comboEmpresa.setItems(empresas);

        comboEmpresa.setConverter(new StringConverter<Empresa>() {
            @Override
            public String toString(Empresa object) {
                if (object != null) {
                    return object.getNombre();
                } else {
                    return "SIN EMPRESA";
                }
            }

            @Override
            public Empresa fromString(String param) {
                try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
                    Query q = s.createSQLQuery("from Empresa where nombre=:nombre");
                    q.setParameter("nombre", param);
                    return (Empresa) q.list().get(0);
                }
            }
        });

    }

    @FXML
    private void btnAñadir(ActionEvent event) {

        Alumno a = leerFormulario();

        if (a != null) {

            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
                Transaction t = s.beginTransaction();
                s.save(a);
                t.commit();

                alumnoActual = a;
                try {
                    App.setRoot("P_listaAlumnos");
                } catch (IOException ex) {
                    Logger.getLogger(P_crear_Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

    @FXML
    private void seleccionarModalidad(ActionEvent event) {
        if (radioDual.isSelected()) {
            txtDual.setDisable(false);
            txtFct.setDisable(true);
            txtFct.setText("0");
        }
        if (radioFct.isSelected()) {
            txtFct.setDisable(false);
            txtDual.setDisable(true);
            txtDual.setText("0");
        }

    }

    @FXML
    private void Volver(ActionEvent event) {

        try {
            App.setRoot("P_listaAlumnos");
        } catch (IOException ex) {
            Logger.getLogger(P_crear_Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Cerrar(ActionEvent event) {

        SessionData.setProfesor(null);
        try {
            App.setRoot("Login");
        } catch (IOException ex) {
            Logger.getLogger(P_listaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
