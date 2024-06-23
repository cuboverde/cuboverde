package com.curdcuboverde.controller;

import com.curdcuboverde.entity.Publication;
import com.curdcuboverde.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/publications")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @GetMapping
    public List<Publication> getAll(){
        return publicationService.getPublications();
    }

    @GetMapping("/{IdPublication}")
    public Optional<Publication> getBId(@PathVariable("IdPublication") Long IdPublication){
        return publicationService.getPublications(IdPublication);
    }


    @PostMapping
    public void saveUpdate (@RequestBody Publication publication){
        publicationService.saveOrUpdate(publication);
    }

    @DeleteMapping("/{IdPublication}")
    public void delete(@PathVariable("IdPublication") Long IdPublication){
        publicationService.delete(IdPublication);
    }
}
