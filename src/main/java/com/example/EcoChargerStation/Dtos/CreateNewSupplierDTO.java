package com.example.EcoChargerStation.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateNewSupplierDTO(@NotBlank @NotEmpty String name,
                                   @NotBlank @NotEmpty String password,
                                   @NotBlank @NotEmpty String email,
                                   @NotBlank @NotEmpty String phone,
                                   @NotBlank @NotEmpty String userName,
                                   @NotBlank @NotEmpty String cnpj){}
