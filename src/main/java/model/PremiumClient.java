package model;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorValue("Premium")
@Access(AccessType.FIELD)
public class PremiumClient extends ClientType{

    @Override
    public double applyDiscount(double price) {
        discount = 0.7 * price;
        return discount;
    }
}
