package com.example.EcoChargerStation.Services;


import com.example.EcoChargerStation.Dtos.CreateStationDTO;
import com.example.EcoChargerStation.Models.Station;
import com.example.EcoChargerStation.Repository.interfaces.IStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServices {
    @Autowired
    private IStationRepository stationRepository;

    public CreateStationDTO AddStation(CreateStationDTO createStationDTO){
        stationRepository.AddStation(createStationDTO);
        return createStationDTO;
    }

    public void DeleteStationByID(long id) {
        stationRepository.DeleteStation(id);
    }

    public List<Station> getAllById(long id){
        return stationRepository.getAllById(id);
    }
}
