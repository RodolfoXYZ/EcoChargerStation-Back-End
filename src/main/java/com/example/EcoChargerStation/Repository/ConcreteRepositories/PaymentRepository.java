package com.example.EcoChargerStation.Repository.ConcreteRepositories;

import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.Point;
import com.example.EcoChargerStation.Models.Recharge;
import com.example.EcoChargerStation.Models.Vehicle;
import com.example.EcoChargerStation.Repository.interfaces.IPaymentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository implements IPaymentRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public boolean ConfirmPayment(Recharge recharge) {
        recharge.setAvailability(true);
        em.persist(recharge);
        return true;
    }

    @Override
    @Transactional
    public Long CreatePayment(Client clientId, Point pointId, float value, Vehicle vehicleId){
                Recharge recharge = new Recharge();
                recharge.setAvailability(false);
                recharge.setRechargeDate("sass");
                recharge.setRechargeValue(value);
                recharge.setClient(clientId);
                recharge.setPointId(pointId);
                recharge.setRecharged(false);
                recharge.setVehicle(vehicleId);
                em.persist(recharge);
                return recharge.getRechargeId();
    }

    @Override
    @Transactional
    public boolean ExistAPaymentWithTheseParams(Client client, Point point){
        Long number = (Long) em.createQuery("SELECT COUNT(c) FROM Recharge c WHERE c.client = :client and c.availability = false and c.pointId = :point")
                .setParameter("client", client)
                .setParameter("point", point)
                .getSingleResult();
        return number > 0;
    }
}
