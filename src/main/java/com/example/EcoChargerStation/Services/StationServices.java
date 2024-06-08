package com.example.EcoChargerStation.Services;


import com.example.EcoChargerStation.Dtos.CreateStationDTO;
import com.example.EcoChargerStation.Repository.interfaces.IStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationServices {
    @Autowired
    private IStationRepository stationRepository;

    public CreateStationDTO AddStation(CreateStationDTO createStationDTO){
        stationRepository.AddStation(createStationDTO);
        return createStationDTO;
    }
}
