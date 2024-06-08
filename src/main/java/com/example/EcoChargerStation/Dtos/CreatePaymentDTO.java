package com.example.EcoChargerStation.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreatePaymentDTO(@NotBlank @NotEmpty @NotNull Long clientId,
                               @NotBlank @NotEmpty @NotNull Long pointId,
                               @NotBlank @NotEmpty @NotNull float value,
                               @NotBlank @NotEmpty @NotNull Long vehicleId) {

}
