package managers;

import model.Client;
import repositories.ClientRepository;

import java.io.Serializable;
//import java.util.List;

public class ClientManager implements Serializable {
    private ClientRepository repo;

    public ClientManager(ClientRepository repo) {
        if (repo == null) {
            throw new IllegalArgumentException("clientRepository cannot be null");
        } else {
            this.repo = repo;
        }
    }

    public Client registerClient(Client client) {
        Client newClient = repo.get(client.getID());
        if(newClient == null) {
            repo.add(client);
            return client;
        } else {
            return newClient;
        }
    }

    public void unregisterClient(Client client) {
        if(client != null) {
            repo.remove(client);
        }
    }

    /*public List<Client> findAllClients(){
        //#TODO: pobrać liste klientów
    }*/
}
