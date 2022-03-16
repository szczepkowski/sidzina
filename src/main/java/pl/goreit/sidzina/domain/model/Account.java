package pl.goreit.sidzina.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Account {

    @Id
    private String id;
    private Company company;
    private Person person;
    private Address address;

    private Type type;

    public Account(String id, Person person, Address address, Company company) {
        this.id = id;
        this.person = person;
        this.address = address;
        this.company = company;
        this.type = Type.COMPANY;
    }

    public Account(String id, Person person, Address address) {
        this.id = id;
        this.person = person;
        this.address = address;
        this.type = Type.PRIVATE;
    }


    public Address getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public Type getType() {
        return type;
    }

    private enum Type {
        PRIVATE, COMPANY
    }
}
