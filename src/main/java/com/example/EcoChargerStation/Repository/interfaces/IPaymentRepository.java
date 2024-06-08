package com.example.EcoChargerStation.Repository.interfaces;


import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.Point;
import com.example.EcoChargerStation.Models.Recharge;
import com.example.EcoChargerStation.Models.Vehicle;
import jakarta.transaction.Transactional;

public interface IPaymentRepository {

    boolean ConfirmPayment(Recharge recharge);
    public Long CreatePayment(Client clientId, Point pointId, float value, Vehicle vehicleId);
    public boolean ExistAPaymentWithTheseParams(Client client, Point point);
}
