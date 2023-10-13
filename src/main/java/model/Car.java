package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "Car")

public class Car extends Vehicle implements Serializable {
    @Column(name = "car_horse_power")
    private int horsePower;

    public Car(String plateNumber, double price, int horsePower) {
        super(plateNumber, price);
        this.horsePower = horsePower;
    }

    public Car() {};

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
