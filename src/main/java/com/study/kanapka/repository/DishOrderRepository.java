package com.study.kanapka.repository;

import com.study.kanapka.dto.DishPopularityScaleDto;
import com.study.kanapka.model.Dish;
import com.study.kanapka.model.DishOrder;
import com.study.kanapka.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface DishOrderRepository extends JpaRepository<DishOrder, Long> {

    @Query("select  new com.study.kanapka.dto.DishPopularityScaleDto(sum(d.dishCount), d.dish) " +
            "from DishOrder d where d.order=:order " +
            "group by d.dish")
    List<DishPopularityScaleDto> findAllByOrder(Order order);

    @Query("Select new com.study.kanapka.dto.DishPopularityScaleDto(sum(d.dishCount), d.dish ) " +
            "from DishOrder d " +
            "group by d.dish " +
            "order by sum(d.dishCount) desc")
    Page<DishPopularityScaleDto> searchSortedByPopularityPage(Pageable pageable);

    @Query("Select new com.study.kanapka.dto.DishPopularityScaleDto(sum(d.dishCount), d.dish ) " +
            "from DishOrder d " +
            "group by d.dish " +
            "order by sum(d.dishCount) desc")
    List<DishPopularityScaleDto> searchSortedByPopularity();
}
