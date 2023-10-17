package managers;

import model.Vehicle;
import repositories.VehicleRepository;

public class VehicleManager {
    private VehicleRepository repo;

    public VehicleManager(VehicleRepository repo) {
        if (repo == null) {
            throw new IllegalArgumentException("vehicleRepository cannot be null");
        } else {
            this.repo = repo;
        }
    }

    public Vehicle registerVehicle(Vehicle vehicle) {
        Vehicle newVehicle = repo.get(vehicle.getID());
        if(newVehicle == null) {
            repo.add(vehicle);
            return vehicle;
        } else {
            newVehicle.archive(false);
            return newVehicle;
        }
    }

    public void unregisterVehicle(Vehicle vehicle){
        if(vehicle != null){
            vehicle.archive(true);
        }
    }
}
