package com.example.EcoChargerStation.Repository.interfaces;
import com.example.EcoChargerStation.Dtos.CreateStationDTO;
import com.example.EcoChargerStation.Models.Station;

public interface IStationRepository {
    public CreateStationDTO AddStation(CreateStationDTO station);
    public Station GetStationById(Long id);
}
