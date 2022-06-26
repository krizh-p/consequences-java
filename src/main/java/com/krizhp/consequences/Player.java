package com.krizhp.consequences;

import javafx.scene.control.Button;

public class Player {
    private String tileColor;
    private int orderChosen;
    private Button playerButton;
    private String playerType;

    Player(String tileColor, int orderChosen, Button playerButton) {
        this.tileColor = tileColor;
        this.orderChosen = orderChosen;
        this.playerButton = playerButton;
    }

    public String getPlayerType() {
        return this.playerType;
    }

    public Button getPlayerButton() {
        return this.playerButton;
    }

    public void setPlayerType(String type) {
        this.playerType = type;
    }

    public void setPlayerButton(Button playerButton) {
        this.playerButton = playerButton;
    }


    /**
     * Set the color of the player's tile
     * tileColor
     */
    public void setTileColor(String tileColor) {
        this.tileColor = tileColor;
    }

    /**
     * Set the order the player was chosen
     * orderChosen
     */
    public void setOrderChosen(int orderChosen) {
        this.orderChosen = orderChosen;
    }

    /**
     *
     * @return Returns the tile color
     */
    public String getTileColor() {
        return this.tileColor;
    }

    /**
     *
     * @return Returns an int representing the order the player was picked
     */
    public int getOrderChosen() {
        return this.orderChosen;
    }

    @Override
    public String toString() {
        return "PLAYER\n" + (orderChosen + 1) + "\nSELECTED";
    }
}
