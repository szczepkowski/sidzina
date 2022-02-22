package pl.goreit.sidzina.domain.model;

public class Company {

    private String name;
    private String nip;

    private Address address;

    public Company(String name, String nip) {
        this.name = name;
        this.nip = nip;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getNip() {
        return nip;
    }

    public Address getAddress() {
        return address;
    }
}
