package com.example.planeserializablefiles.view;

import com.example.planeserializablefiles.controller.WelcomeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class WelcomeStage extends Stage {
    private WelcomeController welcomeController;
    private Parent root;

    public WelcomeStage() {
        super();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/planeserializablefiles/welcome-view.fxml"));
        try{
            root = loader.load();
            welcomeController = loader.getController();
        } catch (IOException e){
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        setScene(scene);
        setTitle("Sopa de letras");
        setResizable(false);
        initStyle(StageStyle.UNDECORATED);
        show();
    }

    public WelcomeController getWelcomeController() {
        return welcomeController;
    }

    private static class WelcomeStageHolder {
        private static WelcomeStage INSTANCE;
    }

    public static WelcomeStage getInstance() {
        WelcomeStageHolder.INSTANCE = (WelcomeStageHolder.INSTANCE != null ? WelcomeStageHolder.INSTANCE : new WelcomeStage());
        return WelcomeStageHolder.INSTANCE;
    }

    public static void deleteInstance() {
        WelcomeStageHolder.INSTANCE.close();
        WelcomeStageHolder.INSTANCE = null;
    }
}
