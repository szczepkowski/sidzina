package pl.goreit.sidzina.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Account {

    @Id
    private String login;
    private Company company;
    private Person person;
    private Address address;

    private Type type;

    public Account(String login, Person person, Address address, Company company) {
        this.login = login;
        this.person = person;
        this.address = address;
        this.company = company;
        this.type = Type.COMPANY;
    }

    public Account(String login, Person person, Address address) {
        this.login = login;
        this.person = person;
        this.address = address;
        this.type = Type.PRIVATE;
    }

    public Company getCompany() {
        return company;
    }

    public Address getAddress() {
        return address;
    }

    public String getLogin() {
        return login;
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
