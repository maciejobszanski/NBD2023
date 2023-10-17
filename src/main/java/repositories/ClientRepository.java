package repositories;

import jakarta.persistence.*;
import model.Client;

import java.util.List;

public class ClientRepository implements Repository<Client>{


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    @Override
    public Client get(long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Client.class, id);
        }
    }

    @Override
    public List<Client> getList() {
        try (EntityManager em = emf.createEntityManager()) {
            List<Client> clientsList;
            em.getTransaction().begin();
            clientsList = em.createQuery("FROM model.Client").setLockMode(LockModeType.PESSIMISTIC_WRITE).getResultList();
            em.getTransaction().commit();
            return clientsList;
        }
    }

    @Override
    public boolean remove(Client obj) {
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
    public Client add(Client obj) {
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
