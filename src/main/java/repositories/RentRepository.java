package repositories;

import jakarta.persistence.*;
import model.Rent;

import java.util.List;

public class RentRepository implements Repository<Rent>{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("POSTGRES_RENT_PU");
    @Override
    public Rent get(long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Rent.class, id);
        }
    }

    @Override
    public List<Rent> getList() {
        try (EntityManager em = emf.createEntityManager()) {
            List<Rent> rentsList;
            em.getTransaction().begin();
            rentsList = em.createQuery("FROM model.Rent").setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
            em.getTransaction().commit();
            return rentsList;
        }
    }

    @Override
    public boolean remove(Rent obj) {
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
    public Rent add(Rent obj) {
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
