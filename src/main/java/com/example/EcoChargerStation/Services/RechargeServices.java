package com.example.EcoChargerStation.Services;

import com.example.EcoChargerStation.Dtos.ShowRechargeDTO;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.Recharge;
import com.example.EcoChargerStation.Repository.interfaces.IRechargeRepository;
import com.example.EcoChargerStation.Repository.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeServices {

    @Autowired
    IRechargeRepository repository;
    @Autowired
    UserService userService;


    public List<ShowRechargeDTO> getAll(Client client){
        return repository.getAllRecharges(client);
    }

    public List<ShowRechargeDTO> getAllRechargesById(Long id) throws UserNotFoundException {
        Client client = userService.GetClientById(id);
            return this.getAll(client);
    }



    public Recharge getSingle(Long id){
        return repository.getRechargeById(id);
    }


}
