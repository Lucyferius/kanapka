package com.study.kanapka.dto;

import com.study.kanapka.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NamedEntityGraph
public class FilterDTO {

    private Boolean urgent;
    private Boolean confirmed;
    private Boolean cancelled;
    private Boolean done;

    private Date orderedAtFrom;
    private Date orderedAtTo;

    private Date expectedAtFrom;
    private Date expectedAtTo;

    private List<String> sortBy;
    private List<String> sortOrder;
}
