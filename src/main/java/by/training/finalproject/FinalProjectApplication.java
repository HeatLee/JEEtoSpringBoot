package by.training.finalproject;

import by.training.finalproject.entity.Address;
import by.training.finalproject.entity.Hotel;
import by.training.finalproject.entity.HotelRoom;
import by.training.finalproject.entity.RoomStatus;
import by.training.finalproject.repository.HotelRepository;
import by.training.finalproject.repository.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FinalProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(FinalProjectApplication.class, args);
    }

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    HotelRoomRepository hotelRoomRepository;

    @Override
    public void run(String... strings) throws Exception {

        Address address1 = new Address("Bel", "Minsk");
        Address address2 = new Address("Bel", "Grodno");

        Hotel hotel1 = new Hotel("Viv", 5, address1);
        Hotel hotel2 = new Hotel("Lol", 2, address2);

        List<Hotel> hotels = Arrays.asList(hotel1, hotel2);

//        hotelRepository.save(hotels);
//
//        HotelRoom room = new HotelRoom(3, hotel1,
//                new BigDecimal("50.5"), RoomStatus.AVAILABLE);
//        hotelRoomRepository.save(room);
    }
}
