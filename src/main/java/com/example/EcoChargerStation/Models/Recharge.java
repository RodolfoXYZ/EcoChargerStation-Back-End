package com.example.EcoChargerStation.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Recharge {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rechargeId;
	@ManyToOne
	@JoinColumn(name = "point_id", referencedColumnName = "id")
	private Point pointId;
	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;
	private String rechargeDate;
	private double rechargeValue;
	private boolean availability;
	@ManyToOne
	@JoinColumn(name = "vehicle_id", referencedColumnName = "vehicleId")
	private Vehicle vehicle;
	private boolean isRecharged;
}
