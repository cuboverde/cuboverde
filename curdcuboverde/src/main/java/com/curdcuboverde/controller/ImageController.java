package com.curdcuboverde.controller;

import com.curdcuboverde.entity.Image;
import com.curdcuboverde.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<Image> getAll(){
        return imageService.getImages();
    }

    @GetMapping("/{IdImage}")
    public Optional<Image> getBId(@PathVariable("IdImage") Long IdImage){
        return imageService.getImage(IdImage);
    }


    @PostMapping
    public void saveUpdate (@RequestBody Image image){
        imageService.saveOrUpdate(image);
    }

    @DeleteMapping("/{IdImage}")
    public void delete(@PathVariable("IdImage") Long IdImage){
        imageService.delete(IdImage);
    }
}
