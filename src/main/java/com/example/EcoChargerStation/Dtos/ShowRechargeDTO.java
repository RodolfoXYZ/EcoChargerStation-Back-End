package com.example.EcoChargerStation.Dtos;

import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.Point;

public record ShowRechargeDTO(Long point,
                              String name,
                              String description,
                              String rechargeDate,
                              Double rechargeValue,
                              Boolean availability,
                              Boolean isPayed,
                              String model,
                              Long id,
                              Double quantityPerKw,
                              Double lat,
                              Double lon,
                              Long rechargeId) {
}
