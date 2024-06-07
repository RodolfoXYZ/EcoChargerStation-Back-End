package com.example.EcoChargerStation.Services;

import com.example.EcoChargerStation.Exceptions.UserExceptions.AccountHasBeRegisteredException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.IncorrectDataException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.User;
import com.example.EcoChargerStation.Repository.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    IUserRepository repository;



    public User login(String email, String password) throws UserNotFoundException {

        if(repository.ExistAnUserWithThisParams(email, password)){
            return repository.GetUserByLogin(email, password);
        }
        else if(repository.ExistAnSupplierWithThisParams(email, password)){
            return repository.GetUserByLoginWithSupplier(email, password);
        }
        throw new UserNotFoundException();
    }

     public void RegisterNewUser(String name, String password, String email, String phone, String userName, String cpf) throws AccountHasBeRegisteredException, IncorrectDataException {

        if(name == null || password == null || email == null || phone == null || userName == null || cpf == null){
            throw new IncorrectDataException();
        }
        if(this.repository.ExistAnUserWithThisParams(email, cpf) || this.repository.ExistAnSupplierWithThisParams(email, null) ){
            throw new AccountHasBeRegisteredException();
        }
        this.repository.RegisterNewUser(name, password, email, phone, userName, cpf);
    }

    public void RegisterNewSupplier(String cnpj, String userName, String name, String password, String email, String phone) throws AccountHasBeRegisteredException, IncorrectDataException {

        if(name == null || password == null || email == null || phone == null || userName == null || cnpj == null){
            throw new IncorrectDataException();
        }
        if(this.repository.ExistAnSupplierWithThisParams(email, cnpj) || this.repository.ExistAnUserWithThisParams(email, null)){
            throw new AccountHasBeRegisteredException();
        }
        this.repository.RegisterSupplier(name, password, email, phone, userName, cnpj);
    }

    public void DeleteWithClientId(Long id) throws UserNotFoundException{

        if(!this.repository.ExistAnUserWithThisParams(id)){
            throw new UserNotFoundException();
        }
        this.repository.DeleteByClientId(id);
    }

    public void DeleteWithSupplierId(Long id) throws UserNotFoundException{

        if(!this.repository.ExistAnSupplierWithThisParams(id)){
            throw new UserNotFoundException();
        }
        this.repository.DeleteBySupplierId(id);
    }
    public Client GetClientById(Long id) throws UserNotFoundException{
        if(this.repository.ExistAnUserWithThisParams(id)){
            return this.repository.GetClientById(id);
        }
        else{
            throw new UserNotFoundException();
        }
    }

}
