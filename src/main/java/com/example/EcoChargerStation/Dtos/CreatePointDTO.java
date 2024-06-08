package com.example.EcoChargerStation.Dtos;

import com.example.EcoChargerStation.Models.Station;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePointDTO(@NotNull Station stationId,
                             @NotBlank String connectorType,
                             @NotBlank double price,
                             @NotNull boolean availability) {

}
