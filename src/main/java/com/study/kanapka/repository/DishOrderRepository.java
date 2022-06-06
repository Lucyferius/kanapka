package com.study.kanapka.repository;

import com.study.kanapka.model.DishOrder;
import com.study.kanapka.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishOrderRepository extends JpaRepository<DishOrder, Long> {

    List<DishOrder> findAllByOrder(Order order);
}
