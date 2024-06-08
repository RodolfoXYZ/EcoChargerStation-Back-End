package com.example.EcoChargerStation.Repository.ConcreteRepositories;

import com.example.EcoChargerStation.Dtos.ShowRechargeDTO;
import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.Recharge;
import com.example.EcoChargerStation.Repository.interfaces.IRechargeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RechargeRepository implements IRechargeRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public List<ShowRechargeDTO> getAllRecharges(Client client) {
        TypedQuery<ShowRechargeDTO> query = em.createQuery(
                "SELECT new com.example.EcoChargerStation.Dtos.ShowRechargeDTO(r.pointId.id, r.pointId.stationId.name, r.pointId.stationId.description,r.rechargeDate, r.rechargeValue, r.availability, r.isRecharged, r.vehicle.model, r.vehicle.vehicleId,r.pointId.price ,r.pointId.stationId.address.latitude, r.pointId.stationId.address.longitude, r.id) " +
                        "FROM Recharge r WHERE r.client = :client", ShowRechargeDTO.class);
        query.setParameter("client", client);
        return query.getResultList();
    }

    @Override
    public boolean ExistRechargewithThisCarCredentials(Long id) {
        String jqpl = "SELECT COUNT(r) FROM Recharge r WHERE r.vehicle.id = :id";
        Long number = (Long) em.createQuery(jqpl).setParameter("id", id).getSingleResult();
        return number > 0;
    }

    @Override
    public Recharge getRechargeById(Long id) {
        Recharge result = (Recharge) em.createQuery("FROM Recharge Where id = :id")
                .setParameter("id", id)
                .getSingleResult();
        return result;
    }

    @Override
    public void DeleteRechargeById(Long id) {

    }

    @Override
    public void Recharge(Long id) {
        Recharge recharge = getRechargeById(id);
        recharge.setRecharged(true);
        em.persist(recharge);
    }
}
