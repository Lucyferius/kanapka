package com.study.kanapka.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "dish_types")
public class DishType {

    @Id
    @GeneratedValue(generator = "sec_dish_type", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_dish_type", sequenceName = "sec_dish_type",allocationSize=1)
    private Long id;

    @Column(name = "type", nullable = false, length = 60)
    private String dishType;
}
