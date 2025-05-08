package com.example.planeserializablefiles.model;

public interface ISeriazableFileHandler {
    void serialize(String fileName, Object element);
    Object deserialize(String fileName);
}
