package com.example.EcoChargerStation.Repository.interfaces;
import com.example.EcoChargerStation.Dtos.CreateStationDTO;
import com.example.EcoChargerStation.Models.Station;

import java.util.List;

public interface IStationRepository {
    public CreateStationDTO AddStation(CreateStationDTO station);
    public Station GetStationById(Long id);
    public void DeleteStation(long id);
    public List<Station> getAllById(long id);
}
