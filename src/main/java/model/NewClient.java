package model;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorValue("New")
@Access(AccessType.FIELD)
public class NewClient extends ClientType{

    public NewClient() {
        this.discount = 1;
    }

    @Override
    public double applyDiscount(double price) {
        price *= discount;
        return price;
    }
}
