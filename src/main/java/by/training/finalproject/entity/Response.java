package by.training.finalproject.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "response")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id")
    private int id;
    @OneToOne
    @JoinColumn(name = "request_id", referencedColumnName = "request_id")
    private Request request;
    @OneToOne
    @JoinColumn(name = "hotel_room_id", referencedColumnName = "hotel_room_id")
    private HotelRoom room;

    protected Response() {
    }

    public Response(Request request, HotelRoom room) {
        this.request = request;
        this.room = room;
    }

    public Response(Response response) {
        this.id = response.id;
        this.room = new HotelRoom(response.room);
        this.request = new Request(response.request);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public HotelRoom getRoom() {
        return room;
    }

    public void setRoom(HotelRoom room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        if (id != response.id) return false;
        if (!Objects.equals(request, response.request)) return false;
        return Objects.equals(room, response.room);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (request != null ? request.hashCode():0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", request=" + request +
                ", room=" + room +
                '}';
    }
}
