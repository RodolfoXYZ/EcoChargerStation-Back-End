package com.example.EcoChargerStation.Repository.ConcreteRepositories;

import com.example.EcoChargerStation.Dtos.CreatePointDTO;
import com.example.EcoChargerStation.Dtos.PointDTO;
import com.example.EcoChargerStation.Models.Point;
import com.example.EcoChargerStation.Repository.interfaces.IPointRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PointRepository implements IPointRepository {


    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public CreatePointDTO AddPoint(CreatePointDTO point) {
        String jpql = "INSERT INTO Point(stationId, connectorType, price, availability)" +
                " VALUES (:stationId, :connectorType, :price, :availability)";
        var result = em.createQuery(jpql).setParameter("stationId", point.stationId())
                .setParameter("connectorType", point.connectorType())
                .setParameter("price", point.price())
                .setParameter("availability", point.availability()).executeUpdate();
        return point;
    }



    @Override
    public Point GetPointById(Long id) {
        String jpql = "FROM Point c WHERE c.id = :id";
        return (Point) em.createQuery(jpql).setParameter("id", id).getSingleResult();
    }



    @Override
    public boolean ExistPointWithThisId(Long id) {
        var result = (Long) em.createQuery("SELECT COUNT(c) FROM Point c WHERE c.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        return result > 0;
    }

    @Override
    public List<PointDTO> getAllPointByLocation() {
        String jpql = "SELECT p.id, s.name, s.description, p.connectorType, p.price," +
                "p.availability, a.longitude, a.latitude" +
                " FROM Point p JOIN p.stationId s JOIN s.address a";

        return em.createQuery(jpql, PointDTO.class)
                .getResultList();

    }
}