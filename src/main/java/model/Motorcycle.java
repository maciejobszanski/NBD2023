package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "Motorcycle")

public class Motorcycle extends Vehicle implements Serializable {
    @Column(name = "motorcycle_acceleration")
    private double acceleration;

    public Motorcycle(String plateNumber, double price, double acceleration) {
        super(plateNumber, price);
        this.acceleration = acceleration;
    }

    public Motorcycle() {};

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }
}
