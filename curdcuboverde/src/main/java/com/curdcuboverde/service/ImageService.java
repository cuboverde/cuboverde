package com.curdcuboverde.service;

import com.curdcuboverde.entity.Image;
import com.curdcuboverde.repository.ContentRepository;
import com.curdcuboverde.repository.FeedBackRepository;
import com.curdcuboverde.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ImageService {
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    private FeedBackRepository feedBackRepository;
    @Autowired
    private ContentRepository contentRepository;

    public List<Image> getImages(){

        return imageRepository.findAll();
    }
    public Optional<Image> getImage(Long id){

        return imageRepository.findById(id);
    }

    public void saveOrUpdate(Image image){
        if(feedBackRepository.findById(image.getIdFeedBack()).isPresent()
        || contentRepository.findById(image.getIdContent()).isPresent()){

            imageRepository.save(image);
        }else {
            return;
        }


    }

    public Optional<Image> update(Long id, Image image){
        if(imageRepository.findById(id).isPresent()){
            Image updateImage = imageRepository.findById(id).get();

            updateImage.setUrlImage(image.getUrlImage());
            updateImage.setDescriptionImage(image.getDescriptionImage());
            updateImage.setIdContent(image.getIdContent());
            updateImage.setIdFeedBack(image.getIdFeedBack());

            imageRepository.save(updateImage);
            return imageRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }

    public void delete(Long id){

        imageRepository.deleteById(id);
    }
}
