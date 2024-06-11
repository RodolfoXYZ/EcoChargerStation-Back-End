package com.example.EcoChargerStation.Controller;


import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;
import com.example.EcoChargerStation.Dtos.ErrorBody;
import com.example.EcoChargerStation.Exceptions.VehicleExceptions.VehicleCannotBeDeleteException;
import com.example.EcoChargerStation.Exceptions.VehicleExceptions.VehicleNotFoundException;
import com.example.EcoChargerStation.Services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleServices vehicleServices;

    @PostMapping("/addvehicle")
    public ResponseEntity AddVeiculo(@RequestBody CreateVehicleDTO vehicle){
        try{
            CreateVehicleDTO vehicle1 = vehicleServices.AddVehicle(vehicle);
            return ResponseEntity.ok().body(vehicle1);
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(new ErrorBody("Erro ao processar os dados", "Ocorreu algum erro na hora de processar seus dados"));
        }
   }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteVehicle(@PathVariable Long id){
        try{
            vehicleServices.DeleteVehicleByID(id);
            System.out.println(id);
            return ResponseEntity.ok().body(null);
        }
        catch (VehicleNotFoundException | VehicleCannotBeDeleteException e){
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity GetAllById(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(vehicleServices.getAllById(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
    }
}
