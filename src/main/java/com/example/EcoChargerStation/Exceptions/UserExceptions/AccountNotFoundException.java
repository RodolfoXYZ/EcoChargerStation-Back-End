package com.example.EcoChargerStation.Exceptions.UserExceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(){
        super("Conta não encontra - [AccountNotFoundException]");
    }
}
