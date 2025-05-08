package com.example.planeserializablefiles.model;

public interface ISerializableFileHandler {
    void serialize(String fileName, Object element);
    Object deserialize(String fileName);
}
