package com.krizhp.consequences;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.krizhp.consequences.ConsequencesApplication.HEIGHT;
import static com.krizhp.consequences.ConsequencesApplication.LENGTH;

public class PlayerTypePrompt {
    static String playerType = "human";

    public static String display(String tileColor) throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Choose Player Type");

        ImageView bg = new ImageView(new Image(tileColor + ".png"));
        Button HumanButton = makeButton(window, "human");
        Button RobotButton = makeButton(window, "robot");
        bg.setFitHeight(180);
        bg.setFitWidth(320);

        GridPane layout = FXMLLoader.load(Objects.requireNonNull(PlayerTypePrompt.class.getResource("PlayerTypePrompt.fxml")));
        layout.add(bg,0,0);
        layout.add(HumanButton,0,0);
        layout.add(RobotButton,1,0);
        window.setScene(new Scene(layout, LENGTH/4.0, HEIGHT/4.0));
        window.setResizable(false);
        window.showAndWait();
        return playerType;
    }

    public static void showTooltip(Button b, Color color) {
        b.setTextFill(color);
    }

    public static void hideTooltip(Button b, Color color) {
        b.setTextFill(color);
    }

    public static Button makeButton(Stage window, String type) {
        Button b = new Button("IS THIS A\n" + type.toUpperCase() + "\nPLAYER?");
        b.setLayoutX(89);
        b.setOpacity(.2);
        b.setTextFill(Color.BLACK);
        b.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        b.setOnMouseEntered(e -> showTooltip(b, Color.BLACK));
        b.setOnMouseExited(e -> hideTooltip(b, Color.WHITE));
        b.setOnMouseClicked(e -> {
            playerType = type;
            window.close();
        });
        b.setPrefSize(320, 230);
        b.setAlignment(Pos.CENTER);
        b.setTextAlignment(TextAlignment.CENTER);
        return b;
    }
}
