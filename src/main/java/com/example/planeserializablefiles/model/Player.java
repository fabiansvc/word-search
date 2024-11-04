package com.example.planeserializablefiles.model;

import java.io.Serializable;

public class Player implements Serializable {
    private String nickname;
    private int wordsFound;

    public Player(String nickname, int wordsFound) {
        this.nickname = nickname;
        this.wordsFound = wordsFound;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getWordsFound() {
        return wordsFound;
    }

    public void setWordsFound(int wordsFound) {
        this.wordsFound = wordsFound;
    }
}
