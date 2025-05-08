package com.example.planeserializablefiles.model;

public interface IPlaneTextFileReader {
    void writeToFile(String fileName, String content);
    String[] readFromFile(String fileName);
}
