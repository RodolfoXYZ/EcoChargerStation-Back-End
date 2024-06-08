package com.example.EcoChargerStation.Repository.ConcreteRepositories;

import com.example.EcoChargerStation.Dtos.CreateVehicleDTO;
import com.example.EcoChargerStation.Models.Vehicle;
import com.example.EcoChargerStation.Repository.interfaces.IVehicleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository {


    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public CreateVehicleDTO AddVehicle(CreateVehicleDTO vehicle) {
        String jpql = "INSERT INTO Vehicle(connector, model, battery, ownerId)" +
                " VALUES (:connector, :model, :battery, :ownerId)";
        var result = em.createQuery(jpql).setParameter("connector", vehicle.connector())
                .setParameter("model", vehicle.model())
                .setParameter("battery", vehicle.battery())
                .setParameter("ownerId", vehicle.ownerId()).executeUpdate();
        return vehicle;
    }

    @Transactional
    @Override
    public void DeleteVehicle(long id) {
        String jpql = "DELETE Vehicle c WHERE c.vehicleId = :id";
        em.createQuery(jpql).setParameter("id", id).executeUpdate();
    }

    @Override
    public boolean ExistAVehicle(long id) {
        String jqpl = "SELECT COUNT(v) FROM Vehicle v WHERE v.vehicleId = :id";
        Long number = (Long) em.createQuery(jqpl).setParameter("id", id).getSingleResult();
        return number > 0;
    }

    @Override
    public Vehicle GetVehicleById(long id) {
        String jqpl = "SELECT v FROM Vehicle v WHERE v.vehicleId = :id";
        Vehicle vehicle = em.createQuery(jqpl, Vehicle.class).setParameter("id", id).getSingleResult();
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllById(long id) {
        return em.createQuery("SELECT v FROM Vehicle v WHERE ownerId = :id", Vehicle.class)
                .setParameter("id", id)
                .getResultList();
    }
}
