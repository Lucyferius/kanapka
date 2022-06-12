package com.study.kanapka.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrdersReservationsDTO {

    private String guestFirstName;
    private String guestLastName;
    private String guestPhone;
    private String roomNumber;
    private Date from;
    private Date to;
    private String reservationCode;
    private boolean cancelled;
    List<OrderGetDTO> orders;
}
