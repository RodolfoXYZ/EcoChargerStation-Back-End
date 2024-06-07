package com.example.EcoChargerStation.Exceptions.UserExceptions;

public class IncorrectDataException extends Exception {
    public IncorrectDataException(){
        super("Dados incorretos na hora de criar a conta! - [IncorrectDataException]");
    }
}
