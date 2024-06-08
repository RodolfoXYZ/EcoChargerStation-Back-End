package com.example.EcoChargerStation.Exceptions.VehicleExceptions;

public class VehicleNotFoundException extends Exception{
    public VehicleNotFoundException(){
        super("Nenhum veículo encontado com esse ID - [VehicleNotFoundException]");
    }
}
