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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Actividad;
import models.Alumno;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class A_listaActividades implements Initializable {

    @FXML
    private TableView<Actividad> tablaActividad;

    @FXML
    private TextField txtHoras;
    @FXML
    private ComboBox<String> comboTipoActividad;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnBorrar;
    @FXML
    private TableColumn<Actividad, LocalDate> Fecha;
    @FXML
    private TableColumn<Actividad, String> TipoActividad;
    @FXML
    private TableColumn<Actividad, Integer> Horas;
    @FXML
    private TableColumn<Actividad, String> Actividad;
    @FXML
    private TableColumn<Actividad, String> Observaciones;
    @FXML
    private DatePicker txtFecha;

    private Actividad actividadActual = null;
    @FXML
    private Button btnAñadir;
    @FXML
    private Button ProfesorBTN;
    @FXML
    private Button EmpresaBTN;
    @FXML
    private Button HorasBTN;
    @FXML
    private MenuItem btnCerrarSesion;
    @FXML
    private TextField txtActividad;
    @FXML
    private TextField txtObservaciones;

    cargarVentana cargarVentana = new cargarVentana();
    @FXML
    private Button btnApagar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        inicializarTablaActividades();
        poblarTablaActividades();
        llenarCombo();
        Alumno AlumnoActual = SessionData.getAlumno();
        SessionData.setProfesor(AlumnoActual.getProfesor());
        SessionData.setEmpresa(AlumnoActual.getEmpresa());
        txtFecha.setValue(LocalDate.now());

    }

    private void inicializarTablaActividades() {
        Fecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        TipoActividad.setCellValueFactory(new PropertyValueFactory("tipo_practica"));
        Actividad.setCellValueFactory(new PropertyValueFactory("nombre"));
        Observaciones.setCellValueFactory(new PropertyValueFactory("observaciones"));
        Horas.setCellValueFactory(new PropertyValueFactory("horas_dia"));

        btnActualizar.setDisable(true);
        btnBorrar.setDisable(true);

    }

    private void poblarTablaActividades() {

        ArrayList<Actividad> actividades = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Conexión realizada con éxito");

            Query q = s.createQuery("from Actividad where alumno_id=" + SessionData.getAlumno().getId());
            actividades = (ArrayList<Actividad>) q.list();
            s.close();
        }

        tablaActividad.getItems().clear();
        tablaActividad.getItems().addAll(actividades);

    }

    public void llenarCombo() {

        ObservableList<String> empresas = FXCollections.observableArrayList();

        if (SessionData.getAlumno().getHoras_fct() > 0) {
            empresas.add("FCT");
        } else if (SessionData.getAlumno().getHoras_dual() > 0) {
            empresas.add("DUAL");
        }
        comboTipoActividad.setItems(empresas);

    }

    public Actividad leerFormulario() {

        Actividad a = new Actividad();
        LocalDate fecha = txtFecha.getValue();

        a.setFecha(fecha);
        a.setHoras_dia(Integer.parseInt(txtHoras.getText()));
        a.setNombre(txtActividad.getText());
        a.setAlumno(SessionData.getAlumno());
        a.setTipo_practica(comboTipoActividad.getValue());
        a.setObservaciones(txtObservaciones.getText());

        actividadActual = a;

        return a;
    }

    @FXML
    private void AñadirActividad(ActionEvent event) {

        Actividad actividad = leerFormulario();
        if (actividad != null && pedirConfirmacion("Añadir",
                "Añadir actividad",
                " va a ser añadida.")) {

            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
                Transaction t = s.beginTransaction();
                s.save(actividad);
                t.commit();
            }
        }

        poblarTablaActividades();

    }

    @FXML
    private void borrarActividad(ActionEvent event) {

        if ((actividadActual != null) && pedirConfirmacion("Borrar",
                "Borrar actividad",
                " va a ser borrada.")) {

            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
                Transaction t = s.beginTransaction();
                s.delete(actividadActual);
                t.commit();

                actividadActual = null;
            }
        }

        poblarTablaActividades();

    }

    @FXML
    private void actualizarAlumno(ActionEvent event) {

        if (actividadActual != null && pedirConfirmacion("Actualizar",
                "Actualizar actividad",
                " va a ser actualizada")) {

            actividadActual.setHoras_dia(Integer.parseInt(txtHoras.getText()));
            actividadActual.setTipo_practica(comboTipoActividad.getValue());
            actividadActual.setObservaciones(txtObservaciones.getText());
            actividadActual.setNombre(txtActividad.getText());
            actividadActual.setFecha(txtFecha.getValue());

            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
                Transaction t = s.beginTransaction();
                s.update(actividadActual);
                t.commit();

            }
        }

        poblarTablaActividades();

    }

    private Boolean pedirConfirmacion(String titulo, String cabecera, String contenido) {
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle(titulo);
        confirmacion.setHeaderText(cabecera);
        confirmacion.setContentText("La actividad " + actividadActual.getNombre() + contenido);
        var result = confirmacion.showAndWait();
        return (result.get()) == ButtonType.OK;
    }

    @FXML
    private void mostrarActividades(MouseEvent event) {

        Actividad actividad = tablaActividad.getSelectionModel().getSelectedItem();
        actividadActual = actividad;

        if (actividad != null) {
            try {
                txtActividad.setText(actividad.getNombre());
                txtFecha.setValue(actividad.getFecha());

                txtHoras.setText(actividad.getHoras_dia() + "");
                txtObservaciones.setText(actividad.getObservaciones());
                comboTipoActividad.getSelectionModel().select(actividad.getTipo_practica());
                btnActualizar.setDisable(false);
                btnBorrar.setDisable(false);

            } catch (Exception ex) {
                Logger.getLogger(A_listaActividades.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void EmpresaAction(ActionEvent event) {

        cargarVentana.cargarVentanaModal("A_DetalleEmpresa", 560, 480);
    }

    @FXML
    private void HorasEmpresa(ActionEvent event) {

        cargarVentana.cargarVentanaModal("A_verHorasEmpresa", 580, 350);

    }

    @FXML
    private void ProfesorAction(ActionEvent event) {

        cargarVentana.cargarVentanaModal("A_DetalleProfesor", 580, 350);
    }

    @FXML
    private void Cerrar(ActionEvent event) {

        SessionData.setProfesor(null);
        SessionData.setAlumno(null);
        try {
            App.setRoot("Login");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
