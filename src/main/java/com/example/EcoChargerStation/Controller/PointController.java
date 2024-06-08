package com.example.EcoChargerStation.Controller;

import com.example.EcoChargerStation.Dtos.CreatePointDTO;
import com.example.EcoChargerStation.Exceptions.PointExceptions.IncorrectDataException;
import com.example.EcoChargerStation.Exceptions.PointExceptions.PointNotFoundException;
import com.example.EcoChargerStation.Services.PointServices;
import jakarta.websocket.server.PathParam;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    PointServices services;



    @PostMapping("/addpoint")
    public ResponseEntity<CreatePointDTO> AddPoint(@NotNull @RequestBody CreatePointDTO point){
        try{
            CreatePointDTO point1 = services.AddNewPoint(point);
            return ResponseEntity.ok().body(point1);
        }
        catch(IncorrectDataException e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }



    @GetMapping("/get")
    public ResponseEntity getAllPointByLocation(){
        try{;
            return ResponseEntity.ok(services.getAllPointByLocation());
        } catch (PointNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
