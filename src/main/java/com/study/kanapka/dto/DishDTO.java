package com.study.kanapka.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DishDTO {
    private Long id;
    private String name;
    private String imagePath;
    private Double weight;
    private Double price;
    private Boolean active;
    private Long dishTypeId;
    private String dishType;
    private String description;
}
