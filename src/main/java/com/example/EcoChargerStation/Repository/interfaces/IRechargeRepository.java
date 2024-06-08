package com.example.EcoChargerStation.Repository.interfaces;

import com.example.EcoChargerStation.Dtos.ShowRechargeDTO;
import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.Point;
import com.example.EcoChargerStation.Models.Recharge;

import java.util.List;

public interface IRechargeRepository {
    public List<ShowRechargeDTO> getAllRecharges(Client client);
    public boolean ExistRechargewithThisCarCredentials(Long id);
    public Recharge getRechargeById(Long id);
    public void DeleteRechargeById(Long id);
    public void Recharge(Long id);
}
