package com.example.planeserializablefiles.controller;

import com.example.planeserializablefiles.model.PlaneTextFileReader;
import com.example.planeserializablefiles.model.Player;
import com.example.planeserializablefiles.model.SeriazableFileHandler;
import com.example.planeserializablefiles.view.GameStage;
import com.example.planeserializablefiles.view.WelcomeStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WelcomeController {
    private PlaneTextFileReader planeTextFileReader;
    private SeriazableFileHandler seriazableFileHandler;

    @FXML
    public void initialize() {
        this.planeTextFileReader = new PlaneTextFileReader();
        this.seriazableFileHandler = new SeriazableFileHandler();
    }

    @FXML
    private TextField userTxt;

    @FXML
    public void handleClickExit(ActionEvent event) {
        WelcomeStage.deleteInstance();
    }

    @FXML
    void handleClickPlay(ActionEvent event) {
        Player player = new Player(userTxt.getText().trim(), 0);

        //String content = player.getNickname() + "," + player.getWordsFound();
        //planeTextFileReader.writeToFile("player_data.csv", content);

        seriazableFileHandler.serialize("player_data.ser", player);

        WelcomeStage.deleteInstance();
        GameStage.getInstance().getGameController().startPlay(player);
    }

    @FXML
    void handleClickContinue(ActionEvent event) {
        //String[] data = planeTextFileReader.readFromFile("player_data.csv");
        //String nickname = data[0];
        //int wordsFounds = Integer.parseInt(data[1]);
        //Player player = new Player(nickname, wordsFounds);

        Player player = (Player) seriazableFileHandler.deserialize("player_data.ser");

        System.out.println(player.getNickname());
        System.out.println(player.getWordsFound());

        WelcomeStage.deleteInstance();
        GameStage.getInstance().getGameController().startPlay(player);
    }
}
