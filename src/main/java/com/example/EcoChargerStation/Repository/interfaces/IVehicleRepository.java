package com.example.EcoChargerStation.Repository.interfaces;

import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;
import com.example.EcoChargerStation.Models.Vehicle;

import java.util.List;


public interface IVehicleRepository {
    public CreateVehicleDTO AddVehicle(CreateVehicleDTO vehicle);
    public boolean ExistAVehicle(long id);
    public void DeleteVehicle(long id);
    public Vehicle GetVehicleById(long id);
    public List<Vehicle> getAllById(long id);
}
