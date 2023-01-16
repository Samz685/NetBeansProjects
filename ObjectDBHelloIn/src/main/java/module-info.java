module com.mycompany.objectdbhelloin {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.persistence;
    requires lombok;
    requires java.sql;
    
    opens models;

    opens com.mycompany.objectdbhelloin to javafx.fxml;
    exports com.mycompany.objectdbhelloin;
}
