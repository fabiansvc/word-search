package com.example.planeserializablefiles.controller;

import com.example.planeserializablefiles.model.PlainTextFileHandler;
import com.example.planeserializablefiles.model.Player;
import com.example.planeserializablefiles.model.SerializableFileHandler;
import com.example.planeserializablefiles.view.GameStage;
import com.example.planeserializablefiles.view.WelcomeStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class WelcomeController {


    @FXML
    private TextField userTxt;

    private PlainTextFileHandler plainTextHandler;
    private SerializableFileHandler serializableFileHandler;

    @FXML
    public void initialize() {
        plainTextHandler = new PlainTextFileHandler();
        serializableFileHandler = new SerializableFileHandler();
    }

    @FXML
    public void handleClickExit(ActionEvent event) {
        WelcomeStage.deleteInstance();
    }

    @FXML
    public void handleClickPlay(ActionEvent event) {
        Player player = new Player(userTxt.getText().trim(), 0);
//        plainTextHandler.writeToFile("player_data.csv",
//                player.getNickname() + "," + player.getWordsFound());

        serializableFileHandler.serialize("player_data.ser", player);

        WelcomeStage.deleteInstance();
        GameStage.getInstance().getGameController().startPlay(player);
    }

    @FXML
    public void handleClickContinue(ActionEvent event) {
//        String[] data = plainTextHandler.readFromFile("player_data.csv");
//
//        String nickname = data[0];
//        int wordsFound = Integer.parseInt(data[1]);
//        Player player = new Player(nickname, wordsFound);
        Player player = (Player) serializableFileHandler.deserialize("player_data.ser");

        WelcomeStage.deleteInstance();
        GameStage.getInstance().getGameController().startPlay(player);
    }
}
