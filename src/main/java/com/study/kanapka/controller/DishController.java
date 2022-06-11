package com.study.kanapka.controller;

import com.study.kanapka.dto.DishDTO;
import com.study.kanapka.dto.IdsDto;
import com.study.kanapka.service.DishService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService){
        this.dishService = dishService;
    }

    /**
     * get all dishes by name like
     *
     * @param name - is a start of string. If it is empty - return all
     * @param pageable - information about pages
     *
     *
     * */
    @GetMapping("/dishes")
    Page<DishDTO> dishesByType(@RequestParam("name") String name, @RequestParam("sort") String sort, @PageableDefault(value = 6) Pageable pageable){
        return dishService.getAllDishesLikeSortedByPrice(name, sort, pageable);
    }

    /**
     * get all dishes by type and name like
     *
     * @param type - name of dish type (lunch, drink...)
     * @param name - is a start of string. If it is empty - return all
     * @param pageable - information about pages
     *
     *
     * */
    @GetMapping("/dishes/{type}")
    Page<DishDTO> dishesByType(@PathVariable("type") String type, @RequestParam("name") String name, @RequestParam("sort") String sort, @PageableDefault(value = 6) Pageable pageable){
        return dishService.getAllTypedDishesLikeSortedByPrice(type, name, sort, pageable);
    }

    @GetMapping("/dishes/internal/{ids}")
    List<DishDTO> dishesByIds(@PathVariable Long[] ids){
        return dishService.getDishesByIds(ids);
    }

    @PatchMapping("/dishes/{id}")
    DishDTO updateDish(@PathVariable(value = "id") Long dishId, @RequestBody DishDTO dishDTO){
        return dishService.updateDishById(dishId, dishDTO);
    }

    @DeleteMapping("/dishes/{id}")
    void deleteDish(@PathVariable(value = "id") Long dishId){
        dishService.deleteDishById(dishId);
    }
}
