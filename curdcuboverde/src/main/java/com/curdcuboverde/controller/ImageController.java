package com.curdcuboverde.controller;

import com.curdcuboverde.entity.Image;
import com.curdcuboverde.repository.ContentRepository;
import com.curdcuboverde.repository.FeedBackRepository;
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
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private FeedBackRepository feedBackRepository;

    @GetMapping
    public List<Image> getAll(){

        return imageService.getImages();
    }

    @GetMapping("/{IdImage}")
    public Optional<Image> getBId(@PathVariable("IdImage") Long IdImage){

        return imageService.getImage(IdImage);
    }


    @PostMapping
    public Optional<Image> saveUpdate (@RequestBody Image image){

        imageService.saveOrUpdate(image);
        return imageService.getImage(image.getIdImage());
    }

    @PutMapping("/modificar/{id}")
    public Optional<Image> updateIMG(@PathVariable("id") Long id, @RequestBody Image image){
        if(contentRepository.findById(image.getIdContent()).isPresent() ||
           feedBackRepository.findById(image.getIdFeedBack()).isPresent()){

            imageService.update(id, image);
            return imageService.getImage(id);
        }else{
            return Optional.empty();
        }
    }

    @DeleteMapping("/{IdImage}")
    public void delete(@PathVariable("IdImage") Long IdImage){

        imageService.delete(IdImage);
    }
}
