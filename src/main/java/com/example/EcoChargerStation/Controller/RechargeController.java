package com.example.EcoChargerStation.Controller;


import com.example.EcoChargerStation.Dtos.ShowRechargeDTO;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.example.EcoChargerStation.Models.Recharge;
import com.example.EcoChargerStation.Repository.interfaces.IRechargeRepository;
import com.example.EcoChargerStation.Services.RechargeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recharge")
public class RechargeController {


    @Autowired
    RechargeServices rechargeServices;


    @GetMapping("/all/{id}")
    public List<ShowRechargeDTO> getAllRecharges(@PathVariable Long id){
        try{
            return rechargeServices.getAllRechargesById(id);
        }catch (UserNotFoundException e){
            return new ArrayList<ShowRechargeDTO>();
        }
    }


}
