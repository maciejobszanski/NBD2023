package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "Bus")

public class Bus extends Vehicle implements Serializable {
    @Column(name = "bus_capacity")
    private int capacity;

    public Bus(String plateNumber, double price, int capacity) {
        super(plateNumber, price);
        this.capacity = capacity;
    }

    public Bus() {};

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
