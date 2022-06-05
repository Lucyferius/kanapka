package com.study.kanapka.repository;

import com.study.kanapka.model.DishOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishOrderRepository extends JpaRepository<DishOrder, Long> {
}
