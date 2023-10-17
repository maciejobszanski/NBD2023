package model;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorValue("Premium")
@Access(AccessType.FIELD)
public class PremiumClient extends ClientType{

    public PremiumClient() {
        this.discount = 0.7;
    }

    @Override
    public double applyDiscount(double price) {
        price *= discount;
        return price;
    }
}
