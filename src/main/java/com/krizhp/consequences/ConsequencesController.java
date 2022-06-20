package com.krizhp.consequences;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ConsequencesController {

    @FXML
    private Button GameStartButton;

    @FXML
    private ImageView StartMenuBackgroundImg;

    @FXML
    private AnchorPane StartMenuScreen;

    public void handleButtonAction(ActionEvent e) {
        if (e.getTarget() == GameStartButton) {
            ConsequencesApplication.primaryStage.setScene(ConsequencesApplication.gameScreen);
        }
    }

}
