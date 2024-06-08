package com.example.EcoChargerStation.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Point {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name="station_id")
	private Station stationId;
	@NotBlank
	private String connectorType;
	@NotBlank
	private double price;
	@NotBlank
	private boolean availability;

	public boolean equals(double lat, double lon) {
		double MaiorLat = this.getStationId().getAddress().getLatitude();
		double MaiorLon = this.getStationId().getAddress().getLongitude();
		if(lon > MaiorLon){
			double aux = MaiorLon;
			MaiorLon = lon;
			lon = aux;
		}
		if(lat > MaiorLat){
			double aux = MaiorLat;
			MaiorLat = lat;
			lat = aux;
		}
		return MaiorLon - lon <= 10 && MaiorLat - lat <= 10;
	}
}
