package com.example.planeserializablefiles.model;

public class Player {
    private String nickname;
    private int wordsFound;

    public Player(String nickname) {
        this.nickname = nickname;
        this.wordsFound = 0;
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
