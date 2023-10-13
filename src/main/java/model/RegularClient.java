package model;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorValue("Regular")
@Access(AccessType.FIELD)
public class RegularClient extends ClientType{

    @Override
    public double applyDiscount(double price) {
        discount = 0.85 * price;
        return discount;
    }
}
