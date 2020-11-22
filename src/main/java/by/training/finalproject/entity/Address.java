package by.training.finalproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int id;
    @Column(name = "country")
    private String country;
    @Column(name = "town")
    private String town;

    protected Address() {
    }

    public Address(String country, String town) {
        this.country = country;
        this.town = town;
    }

    public Address(Address address) {
        this.id = address.id;
        this.country = address.country;
        this.town = address.town;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                Objects.equals(country, address.country) &&
                Objects.equals(town, address.town);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (town != null ? town.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}
