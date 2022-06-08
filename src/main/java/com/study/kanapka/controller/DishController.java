package com.study.kanapka.controller;

import com.study.kanapka.dto.DishDTO;
import com.study.kanapka.dto.IdsDto;
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

    @GetMapping("/dishes/internal")
    List<DishDTO> dishesByIds(@RequestBody IdsDto ids){
        return dishService.getDishesByIds(ids);
    }

    @GetMapping("/dishes/internal/{id}")
    DishDTO dishById(@PathVariable("id") Long id){
        return dishService.getDishById(id);
    }

}
