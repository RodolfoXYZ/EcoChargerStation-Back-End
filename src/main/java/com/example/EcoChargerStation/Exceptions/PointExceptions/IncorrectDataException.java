package com.example.EcoChargerStation.Exceptions.PointExceptions;

public class IncorrectDataException extends Exception {
    public IncorrectDataException(){
        super("Dados incorretos na hora de criar o ponto de recarga! - [IncorrectDataException]");
    }
}
