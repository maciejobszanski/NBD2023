package model;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Valid
@Table(name = "Client")
@Access(AccessType.FIELD)
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @Column (name = "userName")
    private String userName;

    @Column (name = "email")
    private String email;

    @Column (name = "client_ID", unique = true)
    private final String clientID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "type_ID")
    private ClientType type;

    @Column(name = "is_archived")
    private boolean isArchived;
    public Client(String userName, String email) {
        this.userName = userName;
        this.email = email;
        this.clientID = UUID.randomUUID().toString();
        this.isArchived = false;
    }

    public Client() {
        this.clientID = UUID.randomUUID().toString();
    }



    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getClientID() {
        return clientID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getID() {
        return ID;
    }

    public ClientType getType() {
        return type;
    }
    public void archive(boolean archive) {
        this.isArchived = archive;
    }
}
