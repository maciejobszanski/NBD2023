package managers;

import jakarta.persistence.*;
import model.Rent;
import repositories.ClientRepository;
import repositories.RentRepository;

public class RentManager {
    private RentRepository repo;

    public RentManager(RentRepository repo) {
        if (repo == null) {
            throw new IllegalArgumentException("rentRepositiory cannot be null");
        } else {
            this.repo = repo;
        }
    }

    public Rent registerRent(Rent rent) {
        Rent newRent = repo.get(rent.getID());
        if(newRent == null) {
            repo.add(rent);
            return rent;
        } else {
            newRent.archive(false);
            return newRent;
        }
    }

    public void unregisterRent(Rent rent) {
        if(rent != null) {
            rent.archive(true);
        }
    }

}
