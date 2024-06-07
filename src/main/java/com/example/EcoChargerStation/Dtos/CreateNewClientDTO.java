package com.example.EcoChargerStation.Dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateNewClientDTO(@NotBlank String name,
                                 @NotBlank String password,
                                 @NotBlank String email,
                                 @NotBlank String phone,
                                 @NotBlank String userName,
                                 @NotBlank String cpf) {
}
