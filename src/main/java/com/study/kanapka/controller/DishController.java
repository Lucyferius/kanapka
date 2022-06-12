package com.study.kanapka.controller;

import com.study.kanapka.dto.DishDTO;
import com.study.kanapka.service.DefaultImageService;
import com.study.kanapka.service.DishService;
import com.study.kanapka.util.DishPopularityReportExporter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class DishController {

    private final DishService dishService;
    private final DefaultImageService imageService;

    public DishController(DishService dishService, DefaultImageService imageService){
        this.imageService = imageService;
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

    @PatchMapping("/admin/dishes/{id}")
    DishDTO updateDish(@PathVariable(value = "id") Long dishId,@RequestParam(name = "data", required = false) String data,
                       @RequestParam(name = "image", required = false) MultipartFile image){
        DishDTO dishDTO =  dishService.getDtoFromJson(data);
        if(image !=null) {
            String imagePath = imageService.saveImage(image);
            dishDTO.setImagePath(imagePath);
        }
        return dishService.updateDishById(dishId, dishDTO);
    }

    @PostMapping("/admin/dishes")
    DishDTO createDish( @RequestParam(name = "data") String data,
                        @RequestParam(name = "image", required = false) MultipartFile image){
        DishDTO dishDTO =  dishService.getDtoFromJson(data);
        if(image !=null) {
            String imagePath = imageService.saveImage(image);
            dishDTO.setImagePath(imagePath);
        }
        return dishService.createDish(dishDTO);
    }

    @DeleteMapping("/admin/dishes/{id}")
    void deleteDish(@PathVariable(value = "id") Long dishId){
        dishService.deleteDishById(dishId);
    }

}
