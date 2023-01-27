module com.paco.javafxreports {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.sql;
    
    opens com.paco.javafxreports to javafx.fxml, javafx.swing, java.sql;
    exports com.paco.javafxreports;
    requires jasperreports;
}
