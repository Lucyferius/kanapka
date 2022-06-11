package com.study.kanapka.repository;

import com.study.kanapka.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

    Order findOrderByCode(String code);

    List<Order> findAllByIdIsIn(List<Long> ids);

}
