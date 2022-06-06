package com.study.kanapka.repository;

import com.study.kanapka.model.Dish;
import com.study.kanapka.model.DishType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DishRepository extends PagingAndSortingRepository<Dish, Long> {

    List<Dish> findAllByIdIsIn(List<Long> ids);

    Dish findDistinctById(Long id);

    @Query("SELECT d FROM Dish d  WHERE LOWER(d.name) LIKE %:name% AND d.dishType=:dishType AND d.active=true")
    Page<Dish> searchAllByDishTypeAndNameLike(@Param("dishType") DishType dishType,
                                              @Param("name") String name, Pageable pageable);

    @Query("SELECT d FROM Dish d  WHERE LOWER(d.name) LIKE %:name% AND d.active=true")
    Page<Dish> searchAllByNameLike(@Param("name") String name, Pageable pageable);

}
