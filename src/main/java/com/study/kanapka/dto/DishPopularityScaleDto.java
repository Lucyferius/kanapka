package com.study.kanapka.dto;

import com.study.kanapka.model.Dish;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DishPopularityScaleDto {
    private long timesOrdered;
    private Dish dish;
}
