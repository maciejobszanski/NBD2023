package model;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.io.Serializable;

@Entity
@Valid
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)
public abstract class ClientType implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "type_ID")
    private long ID;
    @Column
    protected double discount;

    public ClientType() {
        this.discount = getDiscount();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double applyDiscount(double price) {
        return price;
    }
}
