package com.study.kanapka.controller;

import com.study.kanapka.model.Dish;
import com.study.kanapka.service.DishService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    Page<Dish> dishesByType(@RequestParam("name") String name, @RequestParam("sort") String sort,  @PageableDefault(value = 6) Pageable pageable){
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
    Page<Dish> dishesByType(@PathVariable("type") String type, @RequestParam("name") String name, @RequestParam("sort") String sort, @PageableDefault(value = 6) Pageable pageable){
        return dishService.getAllTypedDishesLikeSortedByPrice(type, name, sort, pageable);
    }

    @GetMapping("/dishes/internal")
    List<Dish> dishesByIds(@RequestBody List<Long> ids){
        return dishService.getDishesByIds(ids);
    }

    @GetMapping("/dishes/internal/{id}")
    Dish dishById(@PathVariable("id") Long id){
        return dishService.getDishById(id);
    }

}
