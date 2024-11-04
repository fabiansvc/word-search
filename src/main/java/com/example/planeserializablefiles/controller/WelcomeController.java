package com.example.planeserializablefiles.controller;

import com.example.planeserializablefiles.model.Player;
import com.example.planeserializablefiles.view.GameStage;
import com.example.planeserializablefiles.view.WelcomeStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class WelcomeController {
    @FXML
    public void initialize() {
    }

    @FXML
    private TextField userTxt;


    @FXML
    public void handleClickExit(ActionEvent event) {
        WelcomeStage.deleteInstance();
    }

    @FXML
    void handleClickPlay(ActionEvent event) {
        WelcomeStage.deleteInstance();
        GameStage.getInstance().getGameController().startPlay(new Player(userTxt.getText().trim()));
    }
}
