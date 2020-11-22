package by.training.finalproject.entity;

import by.training.finalproject.converter.RoomStatusConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "hotel_room")
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_room_id")
    private int id;
    @Column(name = "room_capacity")
    private int capacity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @Column(name = "room_price")
    private BigDecimal price;
    @Column(name = "room_status_id")
    @Convert(converter = RoomStatusConverter.class)
    private RoomStatus status;

    protected HotelRoom() {
    }

    public HotelRoom(int capacity, Hotel hotel, BigDecimal price, RoomStatus status) {
        this.capacity = capacity;
        this.hotel = hotel;
        this.price = price;
        this.status = status;
    }

    public HotelRoom(HotelRoom room) {
        this.id = room.id;
        this.capacity = room.capacity;
        this.hotel = new Hotel(room.hotel);
        this.price = BigDecimal.valueOf(room.price.doubleValue());
        this.status = RoomStatus.getStatusById(room.status.getStatusId());
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoom room = (HotelRoom) o;
        if (id != room.id) return false;
        if (capacity != room.capacity) return false;
        if (!Objects.equals(hotel, room.hotel)) return false;
        if (!Objects.equals(price, room.price)) return false;
        return status == room.status;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + capacity;
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
