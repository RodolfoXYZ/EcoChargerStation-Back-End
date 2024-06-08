package com.example.EcoChargerStation.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "supplier_id")
	private Supplier supplier;

	private String description;
	private String name;

	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
}
