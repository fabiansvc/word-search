package com.example.planeserializablefiles.model;

import java.util.ArrayList;
import java.util.Arrays;

public class WordSearch implements IWordSearch{
    private char[][] table;
    private ArrayList<String> searchWords;
    private String word;
    private int wordsFounds;

    public WordSearch() {
        this.word = "";
        this.wordsFounds = 0;
        table = new char[][] {
                {'C', 'A', 'L', 'I', 'T'},
                {'U', 'A', 'A', 'C', 'O'},
                {'X', 'S', 'L', 'A', 'K'},
                {'A', 'H', 'O', 'D', 'I'},
                {'L', 'I', 'M', 'A', 'O'}
        };
        searchWords = new ArrayList<>(Arrays.asList("CALI", "TOKIO", "DOHA", "LIMA"));
    }

    public char[][] getTable() {
        return table;
    }

    public int getWordsFounds() {
        return wordsFounds;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public Boolean search(String word) {
            this.word += word;
            for(String element : searchWords) {
                if(element.equals(this.word)) {
                    searchWords.remove(element);
                    this.wordsFounds++;
                    this.word = "";
                    return true;
                }
            }
            return false;
    }
}
