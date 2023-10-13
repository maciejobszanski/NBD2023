package libraryRepos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Client;
import org.checkerframework.checker.units.qual.C;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Client client = new Client("maci");

        em.getTransaction().begin();

        em.persist(client);

        em.getTransaction().commit();

        emf.close();
    }
}
