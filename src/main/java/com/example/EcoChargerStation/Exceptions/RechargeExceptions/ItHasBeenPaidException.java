package com.example.EcoChargerStation.Exceptions.RechargeExceptions;

public class ItHasBeenPaidException extends Exception{
    public ItHasBeenPaidException(){
        super("Esta recarga já está disponivel - [ItHasBeenPaidException]");
    }
}
