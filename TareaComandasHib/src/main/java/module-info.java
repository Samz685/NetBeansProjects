module com.mycompany.tareacomandashib {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.tareacomandashib to javafx.fxml;
    exports com.mycompany.tareacomandashib;
}
