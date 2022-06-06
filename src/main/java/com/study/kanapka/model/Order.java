package com.study.kanapka.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "urgent", nullable = false)
    private boolean urgent;

    @Column(name = "ordered_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderedAt;

    @Column(name = "expected_at", nullable = false)
    private Date expectedAt;

    @Column(name = "confirmed", nullable = false)
    private boolean confirmed;

    @Column(name = "cancelled", nullable = false)
    private boolean cancelled;

    @Column(name = "done", nullable = false)
    private boolean done;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", reservation=" + reservation.getId() +
                ", contactNumber='" + contactNumber + '\'' +
                ", urgent=" + urgent +
                ", orderedAt=" + orderedAt +
                ", expectedAt=" + expectedAt +
                ", confirmed=" + confirmed +
                ", cancelled=" + cancelled +
                ", done=" + done +
                '}';
    }
}
