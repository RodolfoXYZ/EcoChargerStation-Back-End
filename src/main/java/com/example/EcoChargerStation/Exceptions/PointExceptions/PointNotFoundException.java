package com.example.EcoChargerStation.Exceptions.PointExceptions;

public class PointNotFoundException extends Exception {
    public PointNotFoundException(){
        super("Point nao encontrado - [PointNotFoundException]");
    }
}
