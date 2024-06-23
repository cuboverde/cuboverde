package com.curdcuboverde.service;

import com.curdcuboverde.entity.Publication;
import com.curdcuboverde.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PublicationService {
    @Autowired
    PublicationRepository publicationRepository;

    public List<Publication> getPublications(){
        return publicationRepository.findAll();
    }
    public Optional<Publication> getPublications(Long id){
        return publicationRepository.findById(id);
    }

    public void saveOrUpdate(Publication publication){
        publicationRepository.save(publication);
    }

    public void delete(Long id){
        publicationRepository.deleteById(id);
    }
}
