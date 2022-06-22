package com.krizhp.consequences;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.util.LinkedList;

public class MenuController {

    private int players = -1;
    private LinkedList<Player> playersSelected = new LinkedList<>();

    //
    //Player Selector Screen Nodes
    //
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

    @FXML
    private Button PlayerSelectionFinishedButton = new Button();

    //
    //Start Screen Nodes
    //
    @FXML
    private Button GameStartButton;

    @FXML
    private ImageView StartMenuBackgroundImg;

    @FXML
    private AnchorPane StartMenuScreen;


    public void handleButtonAction(ActionEvent e) {
        if (e.getTarget() == PlayerOneButton) {
            enablePlayer(PlayerOneButton, "blue", findPlayer(PlayerOneButton));
        }
        else if (e.getTarget() == PlayerTwoButton) {
            enablePlayer(PlayerTwoButton, "yellow", findPlayer(PlayerTwoButton));
        }
        else if (e.getTarget() == PlayerThreeButton) {
            enablePlayer(PlayerThreeButton, "green", findPlayer(PlayerThreeButton));
        }
        else if (e.getTarget() == PlayerFourButton) {
            enablePlayer(PlayerFourButton, "pink", findPlayer(PlayerFourButton));
        }
    }

    private void enablePlayer (Button b, String tileColor, Player playerTargeted) {
        if (b.getText().equals("notEnabled")) {
            players++;
            playersSelected.add(new Player(tileColor, players, b));
            b.setOpacity(.2);
            b.setText(playersSelected.get(players).toString());
        }
        else {
            //Prevent duplicate players
            if (players >= 1) {
                int targetedOrder = playerTargeted.getOrderChosen();
                int counter = 0;
                for (Player player : playersSelected) {
                    if (player != null) {
                        Button playerButton = player.getPlayerButton();

                        //If current playerButton needs to be updated
                        if (player.getOrderChosen() > targetedOrder) {
                            player.setOrderChosen(targetedOrder + counter);
                            playerButton.setText(player.toString());
                            counter++;
                        }
                    }
                }
            }

            playerTargeted.getPlayerButton().setText("notEnabled");
            playerTargeted.getPlayerButton().setOpacity(0);
            playersSelected.remove(playerTargeted);
            players--;
        }
    }

    private Player findPlayer(Button b) {
        if (playersSelected.size() != 0) {
            for (Player player : playersSelected) {
                if (player != null) {
                    if (player.getPlayerButton().equals(b)) {
                        return player;
                    }
                }
            }
        }
        return null;

    }
}
