package com.study.kanapka.service;

import com.study.kanapka.dto.GuestDTO;
import com.study.kanapka.model.Guest;
import com.study.kanapka.model.Reservation;
import com.study.kanapka.repository.GuestRepository;
import com.study.kanapka.repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GuestService {
    private final static Logger logger = LoggerFactory.getLogger(DishService.class);

    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    private GuestService(GuestRepository guestRepository, ReservationRepository reservationRepository){
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public GuestDTO getGuestByReservationCode(String code){
        Reservation reservation = reservationRepository.searchActiveReservationByCode(code, new Date());
        if(reservation == null){
            logger.info("There no active reservation by code {}", code);
            return null;
        }
        return new GuestDTO(reservation.getGuest().getId(), reservation.getGuest().getFirstName(), reservation.getGuest().getSecondName(),
                reservation.getGuest().getPhone(), reservation.getRoom().getRoomNumber());
    }
}
