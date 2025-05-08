package com.example.planeserializablefiles.model;

public interface IPlaneTextFileHandler {
    void writeToFile(String fileName, String content);
    String[] readFromFile(String fileName);
}
