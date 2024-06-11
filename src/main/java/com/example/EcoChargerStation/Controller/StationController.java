package com.example.EcoChargerStation.Controller;
import com.example.EcoChargerStation.Dtos.CreateStationDTO;
import com.example.EcoChargerStation.Services.StationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    StationServices stationServices;

    @PostMapping("/addstation")
    public ResponseEntity<CreateStationDTO> AddPoint(@RequestBody CreateStationDTO station){
        try{
            CreateStationDTO station1 = stationServices.AddStation(station);
            return ResponseEntity.ok().body(station1);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
