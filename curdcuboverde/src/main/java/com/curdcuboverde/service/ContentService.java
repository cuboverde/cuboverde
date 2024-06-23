package com.curdcuboverde.service;

import com.curdcuboverde.entity.Content;
import com.curdcuboverde.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ContentService {
    @Autowired
    ContentRepository contentRepository;

    public List<Content> getContents(){
        return contentRepository.findAll();
    }
    public Optional<Content> getContent(Long id){
        return contentRepository.findById(id);
    }

    public void saveOrUpdate(Content content){
        contentRepository.save(content);
    }

    public void delete(Long id){
        contentRepository.deleteById(id);
    }
}
