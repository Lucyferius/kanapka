package com.study.kanapka.dto;

import com.study.kanapka.model.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OrderGetDTO {

    private long id;
    private String code;
    private String reservationCode;
    private String contactNumber;
    private boolean urgent;
    private Date orderedAt;
    private Date expectedAt;
    private boolean confirmed;
    private boolean cancelled;
    private boolean done;
    private double bill;
    private List<DishPopularityScaleDto> dishes;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code=" + code +
                ", reservation=" + reservationCode +
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
