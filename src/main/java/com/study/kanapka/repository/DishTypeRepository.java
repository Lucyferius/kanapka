package com.study.kanapka.repository;

import com.study.kanapka.model.DishType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishTypeRepository extends JpaRepository<DishType, Long> {

    DishType findDistinctByDishType(String dishType);
}
