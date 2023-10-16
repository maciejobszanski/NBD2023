package repositories;

import jakarta.persistence.*;
import model.Vehicle;

import java.util.List;

public class VehicleRepository implements Repository<Vehicle> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("POSTGRES_RENT_PU");

    @Override
    public Vehicle get(long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Vehicle.class, id);
        }
    }

    @Override
    public List<Vehicle> getList() {
        try (EntityManager em = emf.createEntityManager()) {
            List<Vehicle> vehiclesList;
            em.getTransaction().begin();
            vehiclesList = em.createQuery("FROM model.Vehicle").setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
            em.getTransaction().commit();
            return vehiclesList;
        }
    }

    @Override
    public boolean remove(Vehicle obj) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(em.merge(obj));
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Vehicle add(Vehicle obj) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}
