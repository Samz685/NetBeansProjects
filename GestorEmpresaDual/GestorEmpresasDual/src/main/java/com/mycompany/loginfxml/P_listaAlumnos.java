package com.mycompany.loginfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Actividad;
import models.Alumno;
import models.Profesor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class P_listaAlumnos implements Initializable {

    @FXML
    private TableView<Alumno> tabla;
    @FXML
    private TableColumn<Alumno, Integer> cId;
    @FXML
    private TableColumn<Alumno, String> cNombre;
    @FXML
    private TableColumn<Alumno, String> cApellidos;
    @FXML
    private TableColumn<Alumno, String> cDni;
    @FXML
    private TableColumn<Alumno, String> cEmpresa;

    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnSalir;
    @FXML
    private MenuItem menuSalir;
    @FXML
    private Button btnDetalles;

    @FXML
    private TableView<Actividad> tabla2;
    @FXML
    private TableColumn<Actividad, Date> cFecha;
    @FXML
    private TableColumn<Actividad, String> cTipo;
    @FXML
    private TableColumn<Actividad, Integer> cHoras;
    @FXML
    private TableColumn<Actividad, String> cActividad;
    @FXML
    private TableColumn<Actividad, String> cObservaciones;

    private Alumno alumnoActual = null;
    private Profesor profesorActual = SessionData.getProfesor();
    @FXML
    private Label infoHoras;
    @FXML
    private TextField txthorasRealizadas;
    @FXML
    private Label infoHoras1;
    @FXML
    private TextField txthorasAsignadas;
    @FXML
    private Button btnEmpresas;
    @FXML
    private Button btnApagar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        inicializarTablaAlumnos();
        inicializarTablaActividades();

        btnBorrar.setDisable(true);
        btnDetalles.setDisable(true);

        poblarTablaAlumnos();

        System.out.println(SessionData.getProfesor());

    }

    private void inicializarTablaAlumnos() {
        //tabla alumnos
        cId.setCellValueFactory(new PropertyValueFactory("id"));
        cNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        cApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        cDni.setCellValueFactory(new PropertyValueFactory("dni"));
        cEmpresa.setCellValueFactory((var fila) -> {
            Alumno a = fila.getValue();
            return new ReadOnlyObjectWrapper(a.getEmpresa().getNombre());
        });

    }

    private void inicializarTablaActividades() {
        //tabla actividades
        cFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        cTipo.setCellValueFactory(new PropertyValueFactory("tipo_practica"));
        cHoras.setCellValueFactory(new PropertyValueFactory("horas_dia"));
        cActividad.setCellValueFactory(new PropertyValueFactory("nombre"));
        cObservaciones.setCellValueFactory(new PropertyValueFactory("observaciones"));

    }

    @FXML
    private void seleccionarAlumnado(MouseEvent event) {

        Alumno alumno = tabla.getSelectionModel().getSelectedItem();

        System.out.println(tabla.getSelectionModel().getSelectedIndex());

        if (alumno != null) {

            alumnoActual = alumno;

            actualizarTablaActividades();

            btnBorrar.setDisable(false);
            btnDetalles.setDisable(false);

            mostrarHoras();

            System.out.println(alumnoActual);

        }
    }

    private void poblarTablaAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Conexión realizada con éxito");

            Query q = s.createQuery("from Alumno where tutor_id=:param");
            q.setParameter("param", profesorActual.getId());
            alumnos = (ArrayList<Alumno>) q.list();
        }
        tabla.getItems().clear();
        tabla.getItems().addAll(alumnos);

    }

    public void actualizarTablaActividades() {

        ArrayList<Actividad> actividades = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("from Actividad where alumno_id=:param");
            q.setParameter("param", alumnoActual.getId());
            actividades = (ArrayList<Actividad>) q.list();
        }

        tabla2.getItems().clear();
        tabla2.getItems().addAll(actividades);

    }

    @FXML
    private void borrarAlumno(ActionEvent event) {

        if ((alumnoActual != null) && pedirConfirmacion()) {

            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
                Transaction t = s.beginTransaction();
                s.delete(alumnoActual);
                t.commit();

                alumnoActual = null;

                poblarTablaAlumnos();

            }
        }
    }

    private Boolean pedirConfirmacion() {
        Alert confirmacion = new Alert(AlertType.CONFIRMATION);
        confirmacion.setTitle("Borrar");
        confirmacion.setHeaderText("Solicitud de borrado");
        confirmacion.setContentText("El Alumno " + alumnoActual.getNombre() + " va a ser borrado.");
        var result = confirmacion.showAndWait();
        return (result.get()) == ButtonType.OK;
    }

    public void mostrarHoras() {

        String horasAsignadas = null;
        String horasRealizadas = null;

        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("SELECT SUM(horas_dia) FROM Actividad where alumno_id=: param and tipo_practica=: param2");
            q.setParameter("param", alumnoActual.getId());
            q.setParameter("param2", alumnoActual.getTipo());
            List<Object[]> rows = q.list();
            horasRealizadas = "" + ((rows.get(0) != null) ? rows.get(0) : 0);
            System.out.println(horasRealizadas);

            //Setear horas realizadas en cajetin
            if ("DUAL".equals(alumnoActual.getTipo())) {

                horasAsignadas = String.valueOf(alumnoActual.getHoras_dual());
                txthorasAsignadas.setText(horasAsignadas);

                if (!"0".equals(horasRealizadas)) {
                    txthorasRealizadas.setText(horasRealizadas);

                } else {
                    txthorasRealizadas.setText("SIN EMPEZAR");
                }

            } else if ("FCT".equals(alumnoActual.getTipo())) {

                horasAsignadas = String.valueOf(alumnoActual.getHoras_fct());
                txthorasAsignadas.setText(horasAsignadas);

                if (!"0".equals(horasRealizadas)) {
                    txthorasRealizadas.setText(horasRealizadas);

                } else {
                    txthorasRealizadas.setText("SIN EMPEZAR");
                }
            }

        }

    }

    @FXML
    private void irDetalles(ActionEvent event) {

        SessionData.setAlumno(alumnoActual);

        try {
            App.setRoot("P_DetalleAlumno");
        } catch (IOException ex) {
            Logger.getLogger(P_listaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void AñadirAlumno(ActionEvent event) {

        try {
            App.setRoot("P_crearNuevo");
        } catch (IOException ex) {
            Logger.getLogger(P_DetalleAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void irListaEmpresas(ActionEvent event) {

        try {
            App.setRoot("P_listaEmpresas");
        } catch (IOException ex) {
            Logger.getLogger(P_listaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Cerrar(ActionEvent event) {

       
        profesorActual = null;
        SessionData.setProfesor(null);
        try {
            App.setRoot("Login");
        } catch (IOException ex) {
            Logger.getLogger(P_listaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
