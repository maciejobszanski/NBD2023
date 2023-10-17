package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static java.lang.Math.ceil;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)

public class Rent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @Column(name = "rent_ID")
    private String rentID;

    @Column(name = "rent_start_date")
    private LocalDate rentStartDate;

    @Column(name = "rent_end_date")
    private LocalDate rentEndDate;

    @Column(name = "total_rent_price")
    private double totalRentPrice;

    @Column(name = "is_archived")
    private boolean isArchived;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn
    @NotNull
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn
    @NotNull
    private Vehicle vehicle;

    public Rent(Client client, Vehicle vehicle, LocalDate rentStartDate, LocalDate rentEndDate) {
        this.client = client;
        this.vehicle = vehicle;
        this.rentStartDate = rentStartDate;
        this.rentEndDate = rentEndDate;
        this.totalRentPrice = getFinalRentCost();
        this.rentID = java.util.UUID.randomUUID().toString();
        this.isArchived = false;
    }

    public Rent() {
        this.rentID = java.util.UUID.randomUUID().toString();
    }

    public int getRentDays() {
        return (int) ChronoUnit.DAYS.between(this.rentStartDate, this.rentEndDate);
    }

    public double getRentCost(){
        return this.vehicle.getPrice() * this.getRentDays();
    }

    public double getFinalRentCost(){
        return this.client.getType().applyDiscount(this.getRentCost());
    }

    public void archive(boolean archive) {
        this.isArchived = archive;
    }

    public long getID() {
        return ID;
    }

    public String getRentID() {
        return rentID;
    }

    public LocalDate getRentStartDate() {
        return rentStartDate;
    }

    public LocalDate getRentEndDate() {
        return rentEndDate;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public Client getClient() {
        return client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setRentID(String rentID) {
        this.rentID = rentID;
    }

    public void setRentStartDate(LocalDate rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public void setRentEndDate(LocalDate rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
