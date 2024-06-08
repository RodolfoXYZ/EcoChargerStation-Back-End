package com.example.EcoChargerStation.Services;


import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;
import com.example.EcoChargerStation.Exceptions.VehicleExceptions.VehicleCannotBeDeleteException;
import com.example.EcoChargerStation.Exceptions.VehicleExceptions.VehicleNotFoundException;
import com.example.EcoChargerStation.Models.Vehicle;
import com.example.EcoChargerStation.Repository.interfaces.IPointRepository;
import com.example.EcoChargerStation.Repository.interfaces.IRechargeRepository;
import com.example.EcoChargerStation.Repository.interfaces.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServices {

    @Autowired
    IVehicleRepository vehicleRepository;
    @Autowired
    IRechargeRepository rechargeRepository;



    public CreateVehicleDTO AddVehicle(CreateVehicleDTO vehicle) throws VehicleCannotBeDeleteException {
        return vehicleRepository.AddVehicle(vehicle);
    }
    public void DeleteVehicleByID(long id) throws VehicleNotFoundException, VehicleCannotBeDeleteException {
        if(rechargeRepository.ExistRechargewithThisCarCredentials(id)) throw new VehicleCannotBeDeleteException();
        if(vehicleRepository.ExistAVehicle(id)) vehicleRepository.DeleteVehicle(id);
        else throw new VehicleNotFoundException();
    }
    public Vehicle GetVehicleById(Long id) throws VehicleNotFoundException{
        if(vehicleRepository.ExistAVehicle(id)) return vehicleRepository.GetVehicleById(id);
        else throw new VehicleNotFoundException();
    }

    public List<Vehicle> getAllById(long id){
        return vehicleRepository.getAllById(id);
    }

}
