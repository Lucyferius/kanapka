package com.study.kanapka.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "reservation_from", nullable = false)
    private Date from;

    @Column(name = "reservation_to", nullable = false)
    private Date to;

    @Column(name = "reservation_code", nullable = false, unique = true, length = 6)
    private String reservationCode;

    @Column(name = "reservation_cancelled")
    private boolean cancelled;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", guest=" + guest.getId() +
                ", room=" + room.getId() +
                ", from=" + from +
                ", to=" + to +
                ", reservationCode='" + reservationCode + '\'' +
                ", cancelled=" + cancelled +
                '}';
    }
}
