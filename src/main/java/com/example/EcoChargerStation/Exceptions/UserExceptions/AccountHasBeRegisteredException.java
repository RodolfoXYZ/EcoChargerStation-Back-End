package com.example.EcoChargerStation.Exceptions.UserExceptions;

public class AccountHasBeRegisteredException extends Exception{
    public AccountHasBeRegisteredException(){
        super("Dados já registrados no banco! - [AccountHasBeRegisteredException]");
    }
}
