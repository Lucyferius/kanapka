package com.study.kanapka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OrderGetDTO {

    private long id;
    private long reservationId;
    private String contactNumber;
    private boolean urgent;
    private Date orderedAt;
    private Date expectedAt;
    private boolean confirmed;
    private boolean cancelled;
    private boolean done;
    private double bill;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", reservation=" + reservationId +
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