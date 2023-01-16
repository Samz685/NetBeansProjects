module com.mycompany.objectdbfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.objectdbfx to javafx.fxml;
    exports com.mycompany.objectdbfx;
}
