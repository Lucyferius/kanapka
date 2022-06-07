package com.study.kanapka.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(generator = "sec_dish", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_dish", sequenceName = "sec_dish", allocationSize=1, initialValue = 50)
    private Long id;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "dish_type_id")
    private DishType dishType;

    @Column(name = "description")
    private String description;

}
