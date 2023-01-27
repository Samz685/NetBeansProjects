package com.mycompany.loginfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Alumno;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class A_verHorasEmpresa implements Initializable {

    @FXML
    private TableView<Alumno> tablaHoras;
    @FXML
    private Text TextoLabel;
    @FXML
    private MenuItem btnCerrarSesion;
    @FXML
    private TableColumn<Alumno, String> cHorasRestantesFCT;
    @FXML
    private TableColumn<Alumno, String> cHorasRealizadasFCT;
    @FXML
    private TableColumn<Alumno, String> cHorasRestantesDUAL;
    @FXML
    private TableColumn<Alumno, String> cHorasRealizadasDUAL;
    @FXML
    private Button btnCerrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        CalculoHorasRestantesFCT();
        CalculoHorasRestantesDUAL();

        inicializarTablaHoras();
        poblarTablaHoras();

        if (SessionData.getAlumno().getHoras_dual() > 0) {//Si tiene mas de 1 hora en dual considero que tiene dual
            TextoLabel.setText(SessionData.getAlumno().getNombre() + " " + SessionData.getAlumno().getApellidos() + " tiene dual");
        } else {
            TextoLabel.setText(SessionData.getAlumno().getNombre() + " " + SessionData.getAlumno().getApellidos() + " no tiene dual o no lo ha empezado");
        }

    }

    private void poblarTablaHoras() {
        ArrayList<Alumno> alumno = new ArrayList<>();
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Conexión realizada con éxito");

            Query q = s.createQuery("from Alumno where id=" + SessionData.getAlumno().getId());
            alumno = (ArrayList<Alumno>) q.list();

            s.close();
        }

        tablaHoras.getItems().clear();
        tablaHoras.getItems().addAll(alumno);

    }

    private void inicializarTablaHoras() {
        cHorasRestantesFCT.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(SessionData.getAlumno().getHorasRestantesFCT() + ""));
        cHorasRealizadasFCT.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(SessionData.getAlumno().getHorasRealizadasFCT() + ""));
        cHorasRestantesDUAL.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(SessionData.getAlumno().getHorasRestantesDUAL() + ""));
        cHorasRealizadasDUAL.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(SessionData.getAlumno().getHorasRealizadasDUAL() + ""));
    }

    private int CalculoHorasFCT() {

        int sumaHorasRealizadas;
        String resultadoSuma;

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sumHql = "Select sum(horas_dia) FROM Actividad where alumno_id=" + SessionData.getAlumno().getId() + "and tipo_practica='FCT'";
            Query sumQuery = session.createQuery(sumHql);
            resultadoSuma = sumQuery.list().get(0) + "";
        }

        if (resultadoSuma.equals("null")) {//evitamos un parseint que sea nulo
            sumaHorasRealizadas = 0;
        } else {
            sumaHorasRealizadas = Integer.parseInt(resultadoSuma);
        }

        //Calculo de numero total que me queda del FCT
        if (sumaHorasRealizadas >= 0) {
            SessionData.getAlumno().setHorasRealizadasFCT(sumaHorasRealizadas);
        } else {
            SessionData.getAlumno().setHorasRealizadasFCT(0);//evitamos las horas negativas
        }
        System.out.println(sumaHorasRealizadas);
        return sumaHorasRealizadas;
    }

    private int CalculoHorasDUAL() {

        int sumaHorasRealizadas;
        String resultadoSuma;
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            String sumHql = "Select sum(horas_dia) FROM Actividad where alumno_id=" + SessionData.getAlumno().getId() + "and tipo_practica='DUAL'";
            Query sumQuery = s.createQuery(sumHql);
            resultadoSuma = sumQuery.list().get(0) + "";
        }
        if (resultadoSuma.equals("null")) {//evitamos un parseint que sea nulo
            sumaHorasRealizadas = 0;
        } else {
            sumaHorasRealizadas = Integer.parseInt(resultadoSuma);
        }
        //Calculo de numero total que me queda del dual
        if (sumaHorasRealizadas >= 0) {
            SessionData.getAlumno().setHorasRealizadasDUAL(sumaHorasRealizadas);
        } else {
            SessionData.getAlumno().setHorasRealizadasDUAL(0);//evitamos las horas negativas
        }
        System.out.println(sumaHorasRealizadas);
        return sumaHorasRealizadas;
    }

    private void CalculoHorasRestantesDUAL() {
        int NumeroHorasAsignadas = SessionData.getAlumno().getHoras_dual();
        int HorasRestantes = NumeroHorasAsignadas - CalculoHorasDUAL();
        SessionData.getAlumno().setHorasRestantesDUAL(HorasRestantes);
    }

    private void CalculoHorasRestantesFCT() {
        int NumeroHorasAsignadas = SessionData.getAlumno().getHoras_fct();
        int HorasRestantes = NumeroHorasAsignadas - CalculoHorasFCT();
        System.out.println(HorasRestantes);
        SessionData.getAlumno().setHorasRestantesFCT(HorasRestantes);
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void cerrarSesion(ActionEvent event) {

        SessionData.setAlumno(null);
        try {
            App.setRoot("Login");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
