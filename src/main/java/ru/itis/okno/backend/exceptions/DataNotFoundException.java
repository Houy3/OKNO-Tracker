package ru.itis.okno.backend.exceptions;

public class DataNotFoundException extends ApplicationException {
    public DataNotFoundException(String modelName, String... details) {
        super(modelName + " was not found.", details);
    }
}
