package com.example.EcoChargerStation.Models;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public abstract class User {
	@NotBlank
	private String userName;
	@NotBlank
	private String password;
	@NotBlank
	private String name;
	@Email
	private String email;
	@NotBlank
	private String phone;
}
