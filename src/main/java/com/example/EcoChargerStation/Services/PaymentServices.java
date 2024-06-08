package com.example.EcoChargerStation.Services;
import com.example.EcoChargerStation.Exceptions.PointExceptions.PointNotFoundException;
import com.example.EcoChargerStation.Exceptions.RechargeExceptions.ItHasBeenPaidException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.example.EcoChargerStation.Exceptions.VehicleExceptions.VehicleNotFoundException;
import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.Point;
import com.example.EcoChargerStation.Models.Vehicle;
import com.example.EcoChargerStation.Repository.interfaces.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PaymentServices {

    @Autowired
    IPaymentRepository paymentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PointServices pointServices;
    @Autowired
    RechargeServices rechargeServices;
    @Autowired
    VehicleServices vehicleServices;

    public void ConfirmPayment(Long id) throws ItHasBeenPaidException {
        if(!rechargeServices.getSingle(id).isAvailability()){
            var response = this.paymentRepository.ConfirmPayment(rechargeServices.getSingle(id));
        }
        else{
            throw new ItHasBeenPaidException();
        }
    }
    public Long CreatePayment(Long id, Long pointId, float value, Long VehicleId) throws UserNotFoundException, PointNotFoundException, VehicleNotFoundException {
        Client client = this.userService.GetClientById(id);
        Point point = this.pointServices.getPointById(pointId);
        Vehicle vehicle = this.vehicleServices.GetVehicleById(VehicleId);
        var response = this.paymentRepository.CreatePayment(client, point, value, vehicle);
        return response;
    }

    public Resource createResource(String name) throws MalformedURLException {
        Path newPath = Paths.get("src/main/java/com/example/EcoChargerStation/pictures/").resolve(name);
        Resource newResource = new UrlResource(newPath.toUri());
        return newResource;
    }
}
