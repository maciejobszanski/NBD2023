package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "Scooter")
public class Scooter extends Vehicle implements Serializable {
    @Column(name = "scooter_fuel_consumption")
    private double fuelConsumption;

    public Scooter(String plateNumber, double price, double fuelConsumption) {
        super(plateNumber, price);
        this.fuelConsumption = fuelConsumption;
    }

    public Scooter() {};

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
