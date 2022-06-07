package com.study.kanapka.service;

import com.study.kanapka.dto.DishDTO;
import com.study.kanapka.exception.KanapkaResourceNotFoundException;
import com.study.kanapka.model.Dish;
import com.study.kanapka.model.DishType;
import com.study.kanapka.repository.DishRepository;
import com.study.kanapka.repository.DishTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:webconfig.properties")
public class DishService {

    private static final String KANAPKA_IMAGE_URL_TEMPLATE = "http://%s/image/%s";

    @Value("${kanapka.baseUrl}")
    private String baseUrl;

    private final static Logger logger = LoggerFactory.getLogger(DishService.class);
    private final Locale locale;

    private final DishRepository dishRepository;
    private final DishTypeRepository dishTypeRepository;

    public DishService(DishRepository dishRepository, DishTypeRepository dishTypeRepository){
        this.dishRepository = dishRepository;
        this.dishTypeRepository = dishTypeRepository;
        locale = new Locale("ukr", "UKR");
    }

    public List<DishDTO> getDishesByIds(List<Long> ids){
        return dishRepository.findAllByIdIsIn(ids)
                .stream().map(this::mapDishToDTO)
                .collect(Collectors.toList());
    }

    public DishDTO getDishById(Long id){
        Optional<Dish> dish = dishRepository.findById(id);
        if(dish.isEmpty()) {
            throw new KanapkaResourceNotFoundException("There are no dish by id " + id);
        }
        return mapDishToDTO(dish.get());
    }

    public Page<DishDTO> getAllDishesLikeSortedByPrice(String name, String direction, Pageable pageable){
        Sort.Direction order = getSortDirection(direction);
        String normalized = name.toLowerCase(locale);
        Pageable sorted = pageable;
        if(order != null){
            sorted = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), order, "price", "id");
        }
        Page<Dish> dishes = dishRepository.searchAllByNameLike(normalized,  sorted);
        List<DishDTO> contents = dishes
                .stream().map(this::mapDishToDTO).collect(Collectors.toList());
        return new PageImpl<>(contents, sorted, dishes.getTotalElements());
    }

    public Page<DishDTO> getAllTypedDishesLikeSortedByPrice(String type, String name, String direction, Pageable pageable){
        Sort.Direction order = getSortDirection(direction);
        String normalized = name.toLowerCase(locale);
        DishType dishType = dishTypeRepository.findDistinctByDishType(type);

        if(dishType == null){
            logger.error("There no such dish type by name {}", type);
            throw new KanapkaResourceNotFoundException("No such dish type by name " + type);
        }
        Pageable sorted = pageable;
        if(order != null){
            sorted = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), order, "price", "id");
        }
        Page<Dish> dishes = dishRepository.searchAllByDishTypeAndNameLike(dishType, normalized, sorted);
        List<DishDTO> contents = dishes
                .stream().map(this::mapDishToDTO).collect(Collectors.toList());
        return new PageImpl<>(contents, sorted, dishes.getTotalElements());
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equalsIgnoreCase("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equalsIgnoreCase("desc")) {
            return Sort.Direction.DESC;
        }
        return null;
    }

    private DishDTO mapDishToDTO(Dish dish){
        String imagePath = String.format(KANAPKA_IMAGE_URL_TEMPLATE, baseUrl, dish.getImagePath());
        return new DishDTO(dish.getId(), dish.getName(), imagePath, dish.getWeight(),
                dish.getPrice(), dish.isActive(), dish.getDishType().getId(),
                dish.getDishType().getDishType(), dish.getDescription());
    }
}
