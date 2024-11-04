package com.example.planeserializablefiles;

import com.example.planeserializablefiles.controller.GameController;
import com.example.planeserializablefiles.view.GameStage;
import com.example.planeserializablefiles.view.WelcomeStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        WelcomeStage.getInstance();
    }
}
