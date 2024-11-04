package com.example.planeserializablefiles.controller;

import com.example.planeserializablefiles.model.Player;
import com.example.planeserializablefiles.model.WordSearch;
import com.example.planeserializablefiles.view.GameStage;
import com.example.planeserializablefiles.view.WelcomeStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class GameController {
    @FXML
    private GridPane gridPane;

    @FXML
    private Label wordLabel;

    @FXML
    private Label wordsFoundLabel;

    private Player player;
    private WordSearch wordSearch;
    private ArrayList<Button> wordsSelected;
    private ArrayList<Button> wordsFounds;

    @FXML
    public void initialize() {
        this.wordSearch = new WordSearch();
        this.wordsSelected = new ArrayList<>();
        this.wordsFounds = new ArrayList<>();
    }

    @FXML
    public void handleClickExit(ActionEvent event) {
        GameStage.deleteInstance();
        WelcomeStage.getInstance();
    }

    public void createTable(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Button btn = new Button();
                String text = String.valueOf(this.wordSearch.getTable()[i][j]);
                btn.setText(text);
                btn.setPrefHeight(40);
                btn.setPrefWidth(40);
                btn.getStyleClass().add("button-word");
                btn.getStylesheets().add(String.valueOf(getClass().getResource("/com/example/planeserializablefiles/css/styles-game.css")));
                gridPane.add(btn, j, i);
                handleButtonWord(btn,text);
            }
        }
    }

    private void handleButtonWord(Button button, String word){
        button.setOnAction(event -> {
            wordLabel.setText(wordLabel.getText().concat(word));
            button.setDisable(true);
            wordsSelected.add(button);
            if(wordSearch.search(word)){
                wordsFoundLabel.setText(String.valueOf(wordSearch.getWordsFounds()));
                wordLabel.setText("");
                this.wordsFounds.addAll(wordsSelected);
                this.wordsSelected.clear();
            }
        });
    }

    @FXML
    void handleContextMenuGridPane(ContextMenuEvent event) {
        wordLabel.setText("");
        wordSearch.setWord("");

        if(wordsFounds.isEmpty()){
            for(Button wordSelected : wordsSelected){
                wordSelected.setDisable(false);
            }
        } else{
            for(Button wordSelected : wordsSelected){
                for (Button wordFound : wordsFounds){
                    if(!wordSelected.equals(wordFound)){
                        wordSelected.setDisable(false);
                    }
                }
            }
        }
        this.wordsSelected.clear();
    }

    public void startPlay(Player player) {
        this.player = player;
        createTable();
    }
}
