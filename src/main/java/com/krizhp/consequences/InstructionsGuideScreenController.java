package com.krizhp.consequences;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;

public class InstructionsGuideScreenController implements Initializable {

    @FXML
    private AnchorPane GuideScreenPane;

    @FXML
    private Button PageThreeStartGame;

    @FXML
    private AnchorPane pageOne;

    @FXML
    private Button pageOneGoForward;

    @FXML
    private ImageView pageOneImg;

    @FXML
    private AnchorPane pageThree;

    @FXML
    private Button pageThreeGoBack;

    @FXML
    private ImageView pageThreeImg;

    @FXML
    private AnchorPane pageTwo;

    @FXML
    private Button pageTwoGoBack;

    @FXML
    private Button pageTwoGoForward;

    @FXML
    private ImageView pageTwoImg;

    private LinkedList<AnchorPane> paneList = new LinkedList<>();

    private void togglePage(AnchorPane page) {
        for (AnchorPane pane : paneList) {
            pane.setVisible(pane == page);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneList.add(pageOne);
        paneList.add(pageTwo);
        paneList.add(pageThree);

        //Implement Page One Functions
        pageOneGoForward.setOnMouseClicked(event -> {
            togglePage(pageTwo);
        });

        //Page 2 Functions
        pageTwoGoBack.setOnMouseClicked(event -> {
            togglePage(pageOne);
        });
        pageTwoGoForward.setOnMouseClicked(event -> {
            togglePage(pageThree);
        });

        //Page 3 Functions
        pageThreeGoBack.setOnMouseClicked(event -> togglePage(pageTwo));
        PageThreeStartGame.setOnMouseClicked(event -> {
            Parent rootPlayerSelectScreen = null;
            try {
                rootPlayerSelectScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayerScreen.fxml")));
                ConsequencesApplication.playerSelection = new Scene(rootPlayerSelectScreen, ConsequencesApplication.LENGTH, ConsequencesApplication.HEIGHT);
                ConsequencesApplication.primaryStage.setScene(ConsequencesApplication.playerSelection);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
