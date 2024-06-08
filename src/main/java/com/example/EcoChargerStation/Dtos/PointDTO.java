package com.example.EcoChargerStation.Dtos;

public record PointDTO (Long id,
        String stationName,
        String stationDescription,
        String connectorType,
        Double price,
        Boolean availability,
        Double longitude,
        Double latitude){
}
