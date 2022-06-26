package com.krizhp.consequences;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class PlayerScreenController implements Initializable {

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

    public void handleButtonAction(ActionEvent e) throws IOException {
        PlayerTypePrompt p = new PlayerTypePrompt();
        if (e.getTarget() == PlayerOneButton) {
            enablePlayer(PlayerOneButton, "yellow", findPlayer(PlayerOneButton));
        }
        else if (e.getTarget() == PlayerTwoButton) {
            enablePlayer(PlayerTwoButton, "blue", findPlayer(PlayerTwoButton));
        }
        else if (e.getTarget() == PlayerThreeButton) {
            enablePlayer(PlayerThreeButton, "purple", findPlayer(PlayerThreeButton));
        }
        else if (e.getTarget() == PlayerFourButton) {
            enablePlayer(PlayerFourButton, "green", findPlayer(PlayerFourButton));
        }
    }

    private void enablePlayer (Button b, String tileColor, Player playerTargeted) throws IOException {
        if (b.getText().toLowerCase().contains("enable")) {
            players++;
            Player newPlayer = new Player(tileColor, players, b);
            newPlayer.setPlayerType(PlayerTypePrompt.display(newPlayer.getTileColor() + "Tile"));
            playersSelected.add(newPlayer);
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

    private void showTooltip(Button b) {
        if (b.getText().contains("notEnabled")) {
            b.setOpacity(.2);
            b.setText("CLICK TO\n" + "ENABLE\nPLAYER " + (players+2));
        }
    }

    private void hideTooltip(Button b) {
        if (b.getText().contains("CLICK TO")) {
            b.setText("notEnabled");
            b.setOpacity(0);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        PlayerOneButton.setOnMouseEntered(e -> showTooltip(PlayerOneButton));
        PlayerOneButton.setOnMouseExited(e -> hideTooltip(PlayerOneButton));

        PlayerTwoButton.setOnMouseEntered(e -> showTooltip(PlayerTwoButton));
        PlayerTwoButton.setOnMouseExited(e -> hideTooltip(PlayerTwoButton));

        PlayerThreeButton.setOnMouseEntered(e -> showTooltip(PlayerThreeButton));
        PlayerThreeButton.setOnMouseExited(e -> hideTooltip(PlayerThreeButton));

        PlayerFourButton.setOnMouseEntered(e -> showTooltip(PlayerFourButton));
        PlayerFourButton.setOnMouseExited(e -> hideTooltip(PlayerFourButton));
    }
}