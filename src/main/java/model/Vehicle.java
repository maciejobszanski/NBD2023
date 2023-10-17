package model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Access(AccessType.FIELD)


public abstract class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @Column(name = "vehicle_ID", unique = true)
    private final String vehicleID;

    @Column(name = "plateNumber")
    private String plateNumber;

    @Column(name = "price")
    private double price;
    @Column(name = "is_archived")
    private boolean isArchived;

    public Vehicle(String plateNumber, double price) {
        this.plateNumber = plateNumber;
        this.price = price;
        this.vehicleID = java.util.UUID.randomUUID().toString();
    }

    public Vehicle() {
        this.vehicleID = java.util.UUID.randomUUID().toString();
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getID() {
        return ID;
    }

    public void archive(boolean archive) {
        this.isArchived = archive;
    }
}
