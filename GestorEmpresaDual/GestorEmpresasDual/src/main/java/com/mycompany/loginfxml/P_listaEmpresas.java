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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Empresa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class P_listaEmpresas implements Initializable {

    @FXML
    private TableView<Empresa> tabla;
    @FXML
    private TableColumn<Empresa, Integer> cId;
    @FXML
    private TableColumn<Empresa, String> cNombre;
    @FXML
    private TableColumn<Empresa, String> cTelefono;
    @FXML
    private TableColumn<Empresa, String> cEmail;
    @FXML
    private TableColumn<Empresa, String> cResponsable;
    @FXML
    private TableColumn<Empresa, String> cObservaciones;

    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnSalir;
    @FXML
    private MenuItem menuSalir;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnDetalles;

    Empresa empresaActual = null;

    cargarVentana cargarVentana = new cargarVentana();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        inicializarTablaEmpresas();
        poblarTablaEmpresas();

        btnBorrar.setDisable(true);

        System.out.println(SessionData.getProfesor());

    }

    private void inicializarTablaEmpresas() {

        cId.setCellValueFactory(new PropertyValueFactory("id"));
        cNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        cTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        cEmail.setCellValueFactory(new PropertyValueFactory("email"));
        cResponsable.setCellValueFactory(new PropertyValueFactory("responsable"));
        cObservaciones.setCellValueFactory(new PropertyValueFactory("observaciones"));

    }

    @FXML
    private void seleccionarEmpresa(MouseEvent event) {

        Empresa empresa = tabla.getSelectionModel().getSelectedItem();

        System.out.println(tabla.getSelectionModel().getSelectedIndex());

        if (empresa != null) {

            empresaActual = empresa;
            SessionData.setEmpresa(empresaActual);

            btnBorrar.setDisable(false);
            btnDetalles.setDisable(false);

            System.out.println(empresaActual);

        }
    }

    private void poblarTablaEmpresas() {
        ArrayList<Empresa> empresas = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Conexión realizada con éxito");

            Query q = s.createQuery("from Empresa where id != 11");
            empresas = (ArrayList<Empresa>) q.list();
        }
        tabla.getItems().clear();
        tabla.getItems().addAll(empresas);

    }

    private Boolean pedirConfirmacion() {
        Alert confirmacion = new Alert(AlertType.CONFIRMATION);
        confirmacion.setTitle("Borrar");
        confirmacion.setHeaderText("Solicitud de borrado");
        confirmacion.setContentText("La empresa " + empresaActual.getNombre() + " va a ser borrada.");
        var result = confirmacion.showAndWait();
        return (result.get()) == ButtonType.OK;
    }

    @FXML
    private void borrarEmpresa(ActionEvent event) {

        if ((empresaActual != null) && pedirConfirmacion()) {

            asignarEmpresaCero();

            try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
                Transaction t = s.beginTransaction();
                s.delete(empresaActual);
                t.commit();

                empresaActual = null;

                poblarTablaEmpresas();

            }
        }
    }

    private void asignarEmpresaCero() {

        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            String updateAlumnos = "Update Alumno set empresa_id = 11 where empresa_id = " + SessionData.getEmpresa().getId();
            Query actualizarQuery = s.createQuery(updateAlumnos);
            Transaction t = s.beginTransaction();
            actualizarQuery.executeUpdate();
            t.commit();
        }
    }

    @FXML
    private void irListaAlumnos(ActionEvent event) {

        try {
            App.setRoot("P_listaAlumnos");
        } catch (IOException ex) {
            Logger.getLogger(P_DetalleAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AñadirEmpresa(ActionEvent event) {
        try {
            App.setRoot("P_crearEmpresa");
        } catch (IOException ex) {
            Logger.getLogger(P_DetalleAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void actualizarEmpresa(ActionEvent event) {

        try {
            App.setRoot("P_modificarEmpresa");
        } catch (IOException ex) {
            Logger.getLogger(P_DetalleAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void detallesEmpresa(ActionEvent event) {

        cargarVentana.cargarVentanaModal("A_DetalleEmpresa", 560, 480);
    }

    @FXML
    private void Cerrar(ActionEvent event) {

        empresaActual = null;
        SessionData.setProfesor(null);
        try {
            App.setRoot("Login");
        } catch (IOException ex) {
            Logger.getLogger(P_listaEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
