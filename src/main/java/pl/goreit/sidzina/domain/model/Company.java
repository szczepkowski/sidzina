package pl.goreit.sidzina.domain.model;

public class Company {

    private String nip;
    private String name;

    public Company(String nip, String name) {
        this.nip = nip;
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public String getName() {
        return name;
    }
}
