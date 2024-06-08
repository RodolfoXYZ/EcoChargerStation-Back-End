package com.example.EcoChargerStation.Dtos;

import com.example.EcoChargerStation.Models.Address;
import com.example.EcoChargerStation.Models.Supplier;
import org.hibernate.validator.constraints.NotBlank;

public record CreateStationDTO(@NotBlank Supplier supplierId,
                               @NotBlank String description,
                               @NotBlank String name,
                               @NotBlank Address addressId) {
}
