package com.study.kanapka.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @Column(name = "price_per_night", nullable = false)
    private double pricePerNight;

    @Column(name = "presentation_name", nullable = false)
    private String presentationName;

    @OneToMany(mappedBy = "room",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Reservation> reservations;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", capacity=" + capacity +
                ", roomType=" + roomType.getRoomType() +
                ", pricePerNight=" + pricePerNight +
                ", presentationName='" + presentationName + '\'' +
                '}';
    }
}
