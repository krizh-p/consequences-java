package com.krizhp.consequences;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ConsequencesApplication extends Application {
    public static Stage primaryStage;
    public static Scene startMenu;
    public static Scene gameScreen;


    @Override
    public void start(Stage primaryStage) throws IOException {

        //Load the main menu and the game screen
        ConsequencesApplication.primaryStage = primaryStage;
        Parent startMenuLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartMenu.fxml")));
        Parent gameScreenLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameScreen.fxml")));
        startMenu = new Scene(startMenuLoader, 1280, 720);
        gameScreen = new Scene(gameScreenLoader, 1280, 720);

        //load button
        Button gameStartButton = new Button("Click Me To Go to Screen 2");



        //Set Screen
        primaryStage.setTitle("CONSEQUENCES");
        primaryStage.setScene(startMenu);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}