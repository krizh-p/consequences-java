package com.krizhp.consequences;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class TitleScreenController {
    @FXML
    private Button GameStartButton;

    @FXML
    private ImageView StartMenuBackgroundImg;

    @FXML
    private AnchorPane StartMenuScreen;

    public void handleButtonAction(ActionEvent e) throws IOException {
        if (e.getTarget() == GameStartButton) {
            //switch screens
            Parent rootInstructionsScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InstructionsPrompt.fxml")));
            ConsequencesApplication.playerSelection = new Scene(rootInstructionsScreen, ConsequencesApplication.LENGTH, ConsequencesApplication.HEIGHT);
            ConsequencesApplication.primaryStage.setScene(ConsequencesApplication.playerSelection);
        }
    }

}
