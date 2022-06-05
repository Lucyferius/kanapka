package com.study.kanapka.repository;

import com.study.kanapka.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.reservationCode=:code AND r.from<=:now AND r.to>:now")
    Reservation searchActiveReservationByCode(@Param("code") String code, @Param("now") Date now);

    Reservation findReservationByGuestId(Long id);
}
