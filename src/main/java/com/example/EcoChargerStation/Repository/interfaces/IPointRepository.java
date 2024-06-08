package com.example.EcoChargerStation.Repository.interfaces;

import com.example.EcoChargerStation.Dtos.CreatePointDTO;
import com.example.EcoChargerStation.Dtos.PointDTO;
import com.example.EcoChargerStation.Models.Point;

import java.util.List;

public interface IPointRepository {
    public CreatePointDTO AddPoint(CreatePointDTO point);
    public Point GetPointById(Long id);
    public boolean ExistPointWithThisId(Long id);
    public List<PointDTO> getAllPointByLocation();
}
