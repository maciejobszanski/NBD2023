package model;

import jakarta.persistence.*;
import managers.ClientManager;
import managers.RentManager;
import managers.VehicleManager;
import model.*;
import repositories.ClientRepository;
import repositories.RentRepository;
import repositories.VehicleRepository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ClientType newClient = new NewClient();
        Client client = new Client("maciek", "mail@example.com", newClient);
        Vehicle bus = new Bus("1bus1", 100, 60);

        ClientType premiumClient = new PremiumClient();
        Client client2 = new Client("asia", "mail2@example.com", premiumClient);
        Vehicle motor = new Motorcycle("1motor1", 150, 3);

        LocalDate start_date = LocalDate.of(2023, 10, 17);
        LocalDate end_date = LocalDate.of(2023, 10, 27);

        ClientRepository clientRepo = new ClientRepository();
        RentRepository rentRepo = new RentRepository();
        VehicleRepository vehicleRepo = new VehicleRepository();

        Rent rent = new Rent(client2, bus, start_date, end_date);
        Rent rent2 = new Rent(client, motor, start_date, end_date);

        RentManager rentManager = new RentManager(rentRepo);
        ClientManager clientManager = new ClientManager(clientRepo);
        VehicleManager vehicleManager = new VehicleManager(vehicleRepo);

        clientManager.registerClient(client);
        clientManager.registerClient(client2);
        vehicleManager.registerVehicle(bus);
        vehicleManager.registerVehicle(motor);
        rentManager.registerRent(rent);
        rentManager.registerRent(rent2);
        clientManager.unregisterClient(client);
    }
}
