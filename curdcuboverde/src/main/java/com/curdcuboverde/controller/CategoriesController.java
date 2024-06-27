package com.curdcuboverde.controller;

import com.curdcuboverde.entity.Categories;
import com.curdcuboverde.repository.CategoriesRepository;
import com.curdcuboverde.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
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
    public Optional<Categories> getBId(@PathVariable("IdCategory") Long IdCategory){
        return categoriesService.getCategory(IdCategory);
    }


    @PostMapping
    public Optional<Categories> saveUpdate (@RequestBody Categories categories){

        categoriesService.saveOrUpdate(categories);
        return categoriesService.getCategory(categories.getIdCategory());
    }

    @PutMapping("/modificar/{id}")
    public Optional<Categories> update (@PathVariable("id") Long id, @RequestBody Categories categories){
        if(categoriesService.getCategory(id).isPresent()){
            categoriesService.updateCategories(id, categories);
            return categoriesService.getCategory(id);
        }else{
            return Optional.empty();
        }
    }

    @DeleteMapping("/{IdCategory}")
    public void delete(@PathVariable("IdCategory") Long IdCategory){

        categoriesService.delete(IdCategory);
    }
}
