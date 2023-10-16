package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull
    private Vehicle vehicle;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "rent_start_time")
    private LocalTime rentStartTime;

    @Column(name = "rent_end_time")
    private LocalTime rentEndTime;

    @Column(name = "is_archived")
    private boolean isArchived;

    public int getRentDays() {
        Duration duration = Duration.between(this.rentStartTime, this.rentEndTime);
        return (int)ceil(duration.toDays());
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
}
