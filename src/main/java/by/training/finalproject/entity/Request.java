package by.training.finalproject.entity;

import by.training.finalproject.converter.RequestStatusConverter;
import by.training.finalproject.entity_legacy.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private int id;
    private int capacity;
    private LocalDate checkIn;
    private LocalDate departure;
    private int stars;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "reservation_user_id")
    private ReservationUser reservationUser;
    @Column(name = "status_id")
    @Convert(converter = RequestStatusConverter.class)
    private RequestStatus status;

    protected Request() {
    }

    public Request(int capacity, LocalDate checkIn, LocalDate departure,
                   int stars, Address address, ReservationUser reservationUser, RequestStatus status) {
        this.capacity = capacity;
        this.checkIn = checkIn;
        this.departure = departure;
        this.stars = stars;
        this.address = address;
        this.reservationUser = reservationUser;
        this.status = status;
    }

    public Request(Request request) {
        this.id = request.id;
        this.capacity = request.capacity;
        this.checkIn = LocalDate.of(request.checkIn.getYear(),
                request.checkIn.getMonth(), request.checkIn.getDayOfMonth());
        this.departure = LocalDate.of(request.departure.getYear(),
                request.departure.getMonth(), request.departure.getDayOfMonth());
        this.stars = request.stars;
        this.address = new Address(request.address);
        this.reservationUser = new ReservationUser(request.reservationUser);
        this.status = RequestStatus.getStatusById(request.getStatus().getId());
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public ReservationUser getReservationUser() {
        return reservationUser;
    }

    public void setReservationUser(ReservationUser reservationUser) {
        this.reservationUser = reservationUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = LocalDate.of(checkIn.getYear(), checkIn.getMonth(), checkIn.getDayOfMonth());
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = LocalDate.of(departure.getYear(), departure.getMonth(), departure.getDayOfMonth());
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
        Request request = (Request) o;
        return id == request.id &&
                capacity == request.capacity &&
                stars == request.stars &&
                Objects.equals(reservationUser, request.reservationUser) &&
                Objects.equals(checkIn, request.checkIn) &&
                Objects.equals(departure, request.departure) &&
                Objects.equals(address, request.address);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + capacity;
        result = 31 * result + stars;
        result = 31 * result + (reservationUser != null ? reservationUser.hashCode() : 0);
        result = 31 * result + (checkIn != null ? checkIn.hashCode() : 0);
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", checkIn=" + checkIn +
                ", departure=" + departure +
                ", stars=" + stars +
                ", address=" + address +
                ", reservationUser=" + reservationUser +
                '}';
    }
}
