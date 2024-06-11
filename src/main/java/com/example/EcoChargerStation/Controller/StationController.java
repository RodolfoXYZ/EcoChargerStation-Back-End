package com.example.EcoChargerStation.Controller;
import com.example.EcoChargerStation.Dtos.CreateStationDTO;
import com.example.EcoChargerStation.Dtos.ErrorBody;
import com.example.EcoChargerStation.Exceptions.VehicleExceptions.VehicleCannotBeDeleteException;
import com.example.EcoChargerStation.Exceptions.VehicleExceptions.VehicleNotFoundException;
import com.example.EcoChargerStation.Services.StationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteStation(@PathVariable Long id){
        try{
            stationServices.DeleteStationByID(id);
            System.out.println(id);
            return ResponseEntity.ok().body(null);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity GetAllById(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(stationServices.getAllById(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
    }
}
