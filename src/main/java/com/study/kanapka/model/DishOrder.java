package com.study.kanapka.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dish_order")
public class DishOrder {

    @Id
    @GeneratedValue(generator = "sec_dish_order", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_dish_order", sequenceName = "sec_dish_order",allocationSize=1, initialValue = 20)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Column(name = "dish_count", nullable = false)
    private int dishCount;
}
