module com.mycompany.hellojasper {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.sql;
    requires jasperreports;

    
    opens com.mycompany.hellojasper to javafx.fxml, javafx.swing, java.sql;
    exports com.mycompany.hellojasper;
}
