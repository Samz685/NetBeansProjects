package com.mycompany.tareacomandashib;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private Button btnCarta;
    @FXML
    private Button btnComandas;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
