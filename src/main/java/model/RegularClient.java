package model;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorValue("Regular")
@Access(AccessType.FIELD)
public class RegularClient extends ClientType{

    public RegularClient() {
        this.discount = 0.9;
    }

    @Override
    public double applyDiscount(double price) {
        price *= discount;
        return price;
    }
}
