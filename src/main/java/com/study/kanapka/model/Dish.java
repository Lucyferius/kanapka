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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @Column(name = "weight", nullable = false)
    private String weight;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "dish_type_id")
    private DishType dishType;

    @Column(name = "description")
    private String description;

}
