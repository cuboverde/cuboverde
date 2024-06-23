package com.curdcuboverde.service;

import com.curdcuboverde.entity.Image;
import com.curdcuboverde.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    public List<Image> getImages(){
        return imageRepository.findAll();
    }
    public Optional<Image> getImage(Long id){
        return imageRepository.findById(id);
    }

    public void saveOrUpdate(Image image){
        imageRepository.save(image);
    }

    public void delete(Long id){
        imageRepository.deleteById(id);
    }
}
