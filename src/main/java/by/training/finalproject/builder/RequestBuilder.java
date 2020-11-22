package by.training.finalproject.builder;

import by.training.finalproject.entity_legacy.Address;
import by.training.finalproject.entity_legacy.Request;
import by.training.finalproject.entity_legacy.RequestStatus;
import by.training.finalproject.entity_legacy.User;

import java.time.LocalDate;

public class RequestBuilder {

    private int id;
    private int capacity;
    private LocalDate checkIn;
    private LocalDate departure;
    private int stars;
    private Address address;
    private User reservationUser;
    private RequestStatus status;

    public RequestBuilder buildStatus(int id) {
        this.status = RequestStatus.getStatusById(id);
        return this;
    }

    public RequestBuilder buildRequestId(int id) {
        this.id = id;
        return this;
    }

    public RequestBuilder buildCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public RequestBuilder buildCheckInDate(LocalDate date) {
        this.checkIn = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
        return this;
    }

    public RequestBuilder buildDepartureDate(LocalDate date) {
        this.departure = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
        return this;
    }

    public RequestBuilder buildStars(int stars) {
        this.stars = stars;
        return this;
    }

    public RequestBuilder buildAddress(Address address) {
        this.address = new Address(address);
        return this;
    }

    public RequestBuilder buildReservationUser(User user) {
        this.reservationUser = new User(user);
        return this;
    }

    public Request build() {
        return new Request(id, capacity, checkIn, departure, stars, address, reservationUser, status);
    }

}
