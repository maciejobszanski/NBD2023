package model;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorValue("New")
@Access(AccessType.FIELD)
public class NewClient extends ClientType{

    @Override
    public double applyDiscount(double price) {
        discount = price;
        return discount;
    }
}
