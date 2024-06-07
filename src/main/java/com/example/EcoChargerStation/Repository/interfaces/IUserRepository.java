package com.example.EcoChargerStation.Repository.interfaces;

import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.User;

public interface IUserRepository{
    public User GetUserByLoginWithSupplier(String email, String password);
    public User GetUserByLogin(String email, String password);
    public Client GetClientById(Long id);
    public boolean ExistAnUserWithThisParams(String email, String cpf);
    public boolean ExistAnUserWithThisParams(Long id);
    public void DeleteBySupplierId(Long id);
    public void DeleteByClientId(Long id);
    public boolean ExistAnSupplierWithThisParams(String email, String cnpj);
    public boolean ExistAnSupplierWithThisParams(Long id);
    public void RegisterNewUser(String name, String password, String email, String phone, String userName, String cpf);
    public void RegisterSupplier(String name, String password, String email, String phone, String userName, String cnpj);
}
