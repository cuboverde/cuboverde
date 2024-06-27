package com.curdcuboverde.service;

import com.curdcuboverde.entity.Categories;
import com.curdcuboverde.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;

    public List<Categories> getCategories(){

        return categoriesRepository.findAll();
    }
    public Optional<Categories> getCategory(Long id){

        return categoriesRepository.findById(id);
    }

    public void saveOrUpdate(Categories categories){

        categoriesRepository.save(categories);
    }

    public void updateCategories(Long id, Categories category){
        Categories updateCat = categoriesRepository.findById(id).get();

        updateCat.setDescriptionCategory(category.getDescriptionCategory());

        categoriesRepository.save(updateCat);
    }

    public void delete(Long id){

        categoriesRepository.deleteById(id);
    }
}
