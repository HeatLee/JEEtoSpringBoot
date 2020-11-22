package by.training.finalproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private int id;
    @Column(name = "hotel_name")
    private String name;
    @Column(name = "stars")
    private int stars;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    protected Hotel() {
    }

    public Hotel(String name, int stars, Address address) {
        this.name = name;
        this.stars = stars;
        this.address = address;
    }

    public Hotel(Hotel hotel) {
        this.id = hotel.id;
        this.name = hotel.name;
        this.stars = hotel.stars;
        this.address = new Address(hotel.address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return id == hotel.id &&
                stars == hotel.stars &&
                Objects.equals(name, hotel.name) &&
                Objects.equals(address, hotel.address);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + stars;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", address=" + address +
                '}';
    }
}
