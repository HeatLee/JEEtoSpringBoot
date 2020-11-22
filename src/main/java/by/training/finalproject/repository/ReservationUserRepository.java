package by.training.finalproject.repository;

import by.training.finalproject.entity.ReservationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationUserRepository extends JpaRepository<ReservationUser, Integer> {
}
