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
    private double weight;
    private double price;
    private boolean active;
    private Long dishTypeId;
    private String dishType;
    private String description;
}
