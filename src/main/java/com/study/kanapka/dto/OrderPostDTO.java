package com.study.kanapka.dto;

import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderPostDTO {
    private Long guestId;
    private String phone;
    private Date expectedDate;
    // id and count
    private Map<Long, Integer> dishes = new HashMap<>();
}
