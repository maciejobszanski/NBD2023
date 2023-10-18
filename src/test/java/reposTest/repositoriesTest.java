package reposTest;

import jakarta.persistence.*;
import model.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repositories.ClientRepository;
import repositories.RentRepository;
import repositories.VehicleRepository;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class repositoriesTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ClientRepository clientRepo;
    private static RentRepository rentRepo;
    private static VehicleRepository vehicleRepo;

    @BeforeAll
    static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        clientRepo = new ClientRepository();
        rentRepo = new RentRepository();
        vehicleRepo = new VehicleRepository();
    }

    @AfterAll
    static void afterAll() {
        if (emf != null) {
            emf.close();
        }
    }

    @Test
    void addClient() {
        ClientType RegularClient = new RegularClient();
        Client client1 = new Client("maciek", "mail@example.com", RegularClient);
        clientRepo.add(client1);
        assertNotNull(clientRepo.get(client1.getID()));
    }

    @Test
    void removeClient() {
        ClientType PremiumClient = new PremiumClient();
        Client client1 = new Client("asia", "mail@example.com", PremiumClient);
        clientRepo.add(client1);
        clientRepo.remove(client1);
        assertNull(clientRepo.get(client1.getID()));
    }

    @Test
    void addVehicle() {
        Vehicle bus = new Bus("bussy", 130, 60);
        vehicleRepo.add(bus);
        assertNotNull(vehicleRepo.get(bus.getID()));
    }

    @Test
    void removeVehicle() {
        Vehicle bus = new Bus("bussy", 130, 60);
        vehicleRepo.add(bus);
        vehicleRepo.remove(bus);
        assertNull(vehicleRepo.get(bus.getID()));
    }

//    @Test
//    void addRent() {
//        ClientType PremiumClient = new PremiumClient();
//        Client client1 = new Client("asia", "mail@example.com", PremiumClient);
//        Vehicle motorcycle = new Motorcycle("motor", 150, 3);
//        LocalDate start_date = LocalDate.of(2023, 10, 17);
//        LocalDate end_date = LocalDate.of(2023, 10, 27);
//        Rent rent1 = new Rent(client1, motorcycle, start_date, end_date);
//        rentRepo.add(rent1);
//        assertNotNull(rentRepo.get(rent1.getID()));
//    }
//
//    @Test
//    void removeRent() {
//        ClientType NewClient = new NewClient();
//        Client client1 = new Client("maci", "mail@mailowski.pl", NewClient);
//        Vehicle car = new Car("bussy", 300, 450);
//        LocalDate start_date = LocalDate.of(2023, 10, 17);
//        LocalDate end_date = LocalDate.of(2023, 10, 27);
//        Rent rent1 = new Rent(client1, car, start_date, end_date);
//        rentRepo.add(rent1);
//        rentRepo.remove(rent1);
//        assertNull(rentRepo.get(rent1.getID()));
//    }
}
