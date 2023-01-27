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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.StringConverter;
import models.Alumno;
import models.Empresa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class P_DetalleAlumno implements Initializable {

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
    private ComboBox<Empresa> comboEmpresa;

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

    private Alumno alumnoActual = null;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnAplicar;
    @FXML
    private ToggleGroup Modalidad;
    @FXML
    private RadioButton radioFct;
    @FXML
    private RadioButton radioDual;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        llenarCombo();

        traerAlumno();

        desactivarFields();

    }

    private void desactivarFields() {

        txtNombre.setDisable(true);
        txtApellidos.setDisable(true);
        txtDni.setDisable(true);
        txtEmail.setDisable(true);
        txttelefono.setDisable(true);
        comboEmpresa.setDisable(true);
        txtDual.setDisable(true);
        txtFct.setDisable(true);
        txtFecha.setDisable(true);
        radioDual.setDisable(true);
        radioFct.setDisable(true);

        if (!"0".equals(txtDual.getText())) {
            radioDual.setSelected(true);
            radioFct.setSelected(false);
        } else if (!"0".equals(txtFct.getText())) {
            radioFct.setSelected(true);
            radioDual.setSelected(false);
        }

    }

    private void traerAlumno() {

        alumnoActual = SessionData.getAlumno();

        System.out.println(alumnoActual);

        txtNombre.setText(alumnoActual.getNombre());
        txtApellidos.setText(alumnoActual.getApellidos());
        txtDni.setText(alumnoActual.getDni());
        txtEmail.setText(alumnoActual.getEmail());
        txttelefono.setText(alumnoActual.getTelefono());
        comboEmpresa.setValue(alumnoActual.getEmpresa());
        txtDual.setText(String.valueOf(alumnoActual.getHoras_dual()));
        txtFct.setText(String.valueOf(alumnoActual.getHoras_fct()));
        if (alumnoActual.getFecha_nac() == null) {
            txtFecha.setValue(LocalDate.now());
        } else {
            txtFecha.setValue(alumnoActual.getFecha_nac());
        }

    }

    private void actualizarAlumno(ActionEvent event) {

        if (alumnoActual != null) {

            alumnoActual.setNombre(txtNombre.getText());
            alumnoActual.setApellidos(txtApellidos.getText());
            alumnoActual.setDni(txtDni.getText());
            alumnoActual.setFecha_nac(txtFecha.getValue());
            alumnoActual.setEmail(txtEmail.getText());
            alumnoActual.setTelefono(txttelefono.getText());
            alumnoActual.setEmpresa(comboEmpresa.getValue());
            alumnoActual.setHoras_dual(Integer.parseInt(txtDual.getText()));
            alumnoActual.setHoras_fct(Integer.parseInt(txtFct.getText()));

            //tipo practica
            String tipo = null;
            if (radioDual.isSelected()) {
                tipo = "DUAL";
            } else {
                tipo = "FCT";
            }
            alumnoActual.setTipo(tipo);

            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
                Transaction t = s.beginTransaction();
                s.update(alumnoActual);
                t.commit();

            }
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
    private void btnEditar(ActionEvent event) {

        //desbloqueando las casillas para editar
        txtNombre.setDisable(false);
        txtApellidos.setDisable(false);
        txtDni.setDisable(false);
        txtEmail.setDisable(false);
        txttelefono.setDisable(false);
        comboEmpresa.setDisable(false);
        txtFecha.setDisable(false);
        radioDual.setDisable(false);
        radioFct.setDisable(false);

        if (!"0".equals(txtDual.getText())) {
            txtDual.setDisable(false);
        } else {
            txtFct.setDisable(false);
        }

    }

    @FXML
    private void aplicarCambios(ActionEvent event) {

        if (alumnoActual != null && pedirConfirmacion()) {
            actualizarAlumno(event);
            desactivarFields();
        }
    }

    private Boolean pedirConfirmacion() {
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Actualizar");
        confirmacion.setHeaderText("Actualización datos Alumno");
        confirmacion.setContentText("Los datos de " + alumnoActual.getNombre() + " van a ser actualizados.");
        var result = confirmacion.showAndWait();
        return (result.get()) == ButtonType.OK;
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
            Logger.getLogger(P_DetalleAlumno.class.getName()).log(Level.SEVERE, null, ex);
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
