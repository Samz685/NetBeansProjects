module com.mycompany.hellofxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.hellofxml to javafx.fxml;
    exports com.mycompany.hellofxml;
}
