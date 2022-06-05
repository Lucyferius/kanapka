package com.study.kanapka.service;

import com.study.kanapka.model.Dish;
import com.study.kanapka.model.DishType;
import com.study.kanapka.repository.DishRepository;
import com.study.kanapka.repository.DishTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class DishService {

    private final static Logger logger = LoggerFactory.getLogger(DishService.class);
    private final Locale locale;

    private final DishRepository dishRepository;
    private final DishTypeRepository dishTypeRepository;

    public DishService(DishRepository dishRepository, DishTypeRepository dishTypeRepository){
        this.dishRepository = dishRepository;
        this.dishTypeRepository = dishTypeRepository;
        locale = new Locale("ukr", "UKR");
    }

    public List<Dish> getDishesByIds(List<Long> ids){
        return dishRepository.findAllByIdIsIn(ids);
    }

    public Dish getDishById(Long id){
        return dishRepository.findDistinctById(id);
    }

    public Page<Dish> getAllDishesLikeSortedByPrice(String name, String direction, Pageable pageable){
        Sort.Direction order = getSortDirection(direction);
        String normalized = name.toLowerCase(locale);
        if(order != null){
            Pageable sorted = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), order, "price");
            return dishRepository.searchAllByNameLike(normalized, sorted);
        }else {
            return dishRepository.searchAllByNameLike(normalized, pageable);
        }
    }

    public Page<Dish> getAllTypedDishesLikeSortedByPrice(String type, String name, String direction, Pageable pageable){
        Sort.Direction order = getSortDirection(direction);
        String normalized = name.toLowerCase(locale);
        DishType dishType = dishTypeRepository.findDistinctByDishType(type);

        if(dishType == null){
            logger.error("There no such dish type by name {}", type);
            throw new IllegalArgumentException("No such dish type by name " + type);
        }

        if(order != null){
            Pageable sorted = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), order, "price");
            return dishRepository.searchAllByDishTypeAndNameLike(dishType, normalized, sorted);
        }else {
            return dishRepository.searchAllByDishTypeAndNameLike(dishType, normalized, pageable);
        }
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equalsIgnoreCase("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equalsIgnoreCase("desc")) {
            return Sort.Direction.DESC;
        }
        return null;
    }
}
