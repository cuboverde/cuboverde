package com.curdcuboverde.controller;

import com.curdcuboverde.entity.Categories;
import com.curdcuboverde.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public List<Categories> getAll(){
        return categoriesService.getCategories();
    }

    @GetMapping("/{IdCategory}")
    public Optional<Categories> getBId(@PathVariable("IdCategories") Long IdCategory){
        return categoriesService.getCategory(IdCategory);
    }
    
    @PostMapping
    public void saveUpdate (@RequestBody Categories categories){
        categoriesService.saveOrUpdate(categories);
    }

    @DeleteMapping("/{IdCategory}")
    public void delete(@PathVariable("IdCategory") Long IdCategory){
        categoriesService.delete(IdCategory);
    }
}
