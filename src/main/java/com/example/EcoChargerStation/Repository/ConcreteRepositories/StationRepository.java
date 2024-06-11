package com.example.EcoChargerStation.Repository.ConcreteRepositories;
import com.example.EcoChargerStation.Dtos.CreateStationDTO;
import com.example.EcoChargerStation.Models.Client;
import com.example.EcoChargerStation.Models.Station;
import com.example.EcoChargerStation.Models.Vehicle;
import com.example.EcoChargerStation.Repository.interfaces.IStationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StationRepository implements IStationRepository {


    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public CreateStationDTO AddStation(CreateStationDTO station) {

        System.out.println(station.addressId());
        System.out.println(station.supplierId());
        System.out.println(station.name());
        System.out.println(station.description());
        String sql = "INSERT INTO Station (supplier_id, description, name, address_id) VALUES (?, ?, ?, ?)";
        em.createNativeQuery(sql)
                .setParameter(1, station.supplierId())
                .setParameter(2, station.description())
                .setParameter(3, station.name())
                .setParameter(4, station.addressId())
                .executeUpdate();
        return station;

    }

    @Override
    public Station GetStationById(Long id) {

        String jpql = "FROM Station c WHERE c.id = :id";
        return (Station) em.createQuery(jpql).setParameter("id", id).getSingleResult();
    }

    @Override
    public void DeleteStation(long id) {
        String jpql = "DELETE Station c WHERE c.stationId = :id";
        em.createQuery(jpql).setParameter("id", id).executeUpdate();
    }

    @Override
    public List<Station> getAllById(long id) {
        return em.createQuery("SELECT v FROM Station v WHERE supplierId = :id", Station.class)
                .setParameter("id", id)
                .getResultList();
    }
}