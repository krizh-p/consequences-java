package com.krizhp.consequences;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class InstructionsPromptController implements Initializable {

    @FXML
    private AnchorPane InstructionsPromptAnchor;

    @FXML
    private Button buttonKnow;

    @FXML
    private Button buttonTeach;

    @FXML
    private ImageView instructionsPromptBackground;

    public void onButtonClick(ActionEvent e) throws IOException {
        if (e.getTarget() == buttonKnow) {
            Parent rootPlayerSelectScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayerScreen.fxml")));
            ConsequencesApplication.playerSelection = new Scene(rootPlayerSelectScreen, ConsequencesApplication.LENGTH, ConsequencesApplication.HEIGHT);
            ConsequencesApplication.primaryStage.setScene(ConsequencesApplication.playerSelection);
        }
        else {
            Parent rootInstructionsScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InstructionsGuideScreen.fxml")));
            ConsequencesApplication.gameInstructions = new Scene(rootInstructionsScreen, ConsequencesApplication.LENGTH, ConsequencesApplication.HEIGHT);
            ConsequencesApplication.primaryStage.setScene(ConsequencesApplication.gameInstructions);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonKnow.setOnMouseEntered(event -> {
            buttonKnow.setTextFill(Color.BLACK);
        });
        buttonKnow.setOnMouseExited(event -> {
            buttonKnow.setTextFill(Color.WHITE);
        });
        buttonTeach.setOnMouseEntered(event -> {
            buttonTeach.setTextFill(Color.BLACK);
        });
        buttonTeach.setOnMouseExited(event -> {
            buttonTeach.setTextFill(Color.WHITE);
        });
    }
}
