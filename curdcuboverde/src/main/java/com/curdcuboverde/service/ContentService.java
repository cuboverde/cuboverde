package com.curdcuboverde.service;

import com.curdcuboverde.entity.Content;
import com.curdcuboverde.repository.ContentRepository;
import com.curdcuboverde.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ContentService {
    @Autowired
    ContentRepository contentRepository;
    @Autowired
    private PublicationRepository publicationRepository;

    public List<Content> getContents(){

        return contentRepository.findAll();
    }
    public Optional<Content> getContent(Long id){

        return contentRepository.findById(id);
    }

    public void saveOrUpdate(Content content){

        contentRepository.save(content);
    }

    public Optional<Content> updateContent(Long id, Content content){
        if(contentRepository.findById(id).isPresent()){
            Content updateCont = contentRepository.findById(id).get();

            updateCont.setContent(content.getContent());
            updateCont.setIdPublication(content.getIdPublication());
            contentRepository.save(updateCont);
            return contentRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }

    public void delete(Long id){

        contentRepository.deleteById(id);
    }
}
