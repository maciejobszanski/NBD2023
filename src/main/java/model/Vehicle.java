package model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Access(AccessType.FIELD)


public abstract class Vehicle implements Serializable {
    @Id
    @GeneratedValue
    private long ID;


}
