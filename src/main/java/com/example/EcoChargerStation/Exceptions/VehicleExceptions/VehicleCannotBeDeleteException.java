package com.example.EcoChargerStation.Exceptions.VehicleExceptions;

public class VehicleCannotBeDeleteException extends Exception{
    public VehicleCannotBeDeleteException(){
        super("Vehicle cannot be deleted - [VehicleCannotBeDeleteException]");
    }
}
