package com.krizhp.consequences;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class ConsequencesApplication extends Application {
    public static Stage primaryStage;

    public static final int HEIGHT = 720;
    public static final int LENGTH = 1280;
    public static Scene titleScreen;
    public static Scene gameInstructions;

    @Override
    public void start(Stage primaryStage) throws IOException, URISyntaxException {

        //Load the main menu and the game screen
        ConsequencesApplication.primaryStage = primaryStage;
        Parent rootStartMenu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartMenu.fxml")));
        Parent rootPlayerScreen= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayerScreen.fxml")));
        titleScreen = new Scene(rootStartMenu, LENGTH, HEIGHT);
        gameInstructions = new Scene(rootPlayerScreen, LENGTH, HEIGHT);

        //Set Screen
        primaryStage.setTitle("CONSEQUENCES");
        primaryStage.setScene(titleScreen);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}