package com.example.EcoChargerStation.Exceptions.UserExceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("Nenhum usuário encontrado para estes dados! - [UserNotFoundException]");
    }
}
