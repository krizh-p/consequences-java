package com.krizhp.consequences;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;

public class MenuController {

    private int players = 0;
    //Player Selector Screen Nodes
    @FXML
    private Button PlayerFourButton;

    @FXML
    private Button PlayerOneButton;

    @FXML
    private GridPane PlayerSelectionGridPane;

    @FXML
    private AnchorPane PlayerSelectionScreen;

    @FXML
    private Button PlayerThreeButton;

    @FXML
    private Button PlayerTwoButton;


    //Start Screen Nodes
    @FXML
    private Button GameStartButton;

    @FXML
    private ImageView StartMenuBackgroundImg;

    @FXML
    private AnchorPane StartMenuScreen;

    public void handleButtonAction(ActionEvent e) {
        if (e.getTarget() == GameStartButton) {
            //switch screens
            ConsequencesApplication.primaryStage.setScene(ConsequencesApplication.gameInstructions);

        }
        else  {
            addPlayer(e);

        }
    }

    private void addPlayer(ActionEvent e) {
        if (e.getTarget() == PlayerOneButton) {
            if (PlayerOneButton.getText().equals("notEnabled")) {
                System.out.println("Worked");
                PlayerOneButton.setOpacity(.1);
                PlayerOneButton.setText("Player One Selected");
                players++;

            }
        }
    }
}
