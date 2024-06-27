package com.curdcuboverde.controller;

import com.curdcuboverde.entity.Publication;
import com.curdcuboverde.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/publications")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @GetMapping
    public List<Publication> getAll(){
        return publicationService.getPublications();
    }

    @GetMapping("/approved")
    public List<Publication> getApproved(){
        return publicationService.findAllAproved();
    }

    @GetMapping("/{IdPublication}")
    public Optional<Publication> getBId(@PathVariable("IdPublication") Long IdPublication){
        return publicationService.getPublications(IdPublication);
    }

    @GetMapping("/findByCategory/{idCategory}")
    public List<Publication> getByCategory(@PathVariable("idCategory") Long IdCategory){
        return publicationService.findByCategory(IdCategory);
    }

    @GetMapping("/findByUser/{idUser}")
    public List<Publication> getByUser(@PathVariable("idUser") Long IdUser){
        return publicationService.findByUser(IdUser);
    }


    @PostMapping
    public Optional<Publication> saveUpdate (@RequestBody Publication publication){

        publicationService.saveOrUpdate(publication);
        return publicationService.getPublications(publication.getIdPublication());
    }

    @PutMapping("/modificar/{id}")
    public Optional<Publication> updatePublication (@PathVariable("id") Long id, @RequestBody Publication publication){
        if(publicationService.getPublications(id).isPresent()){
            publicationService.updatePublication(id, publication);
            return publicationService.getPublications(id);
        }else {
            return Optional.empty();
        }

    }

    @PostMapping("/aprove/{id}")
    public Optional<Publication> approvePublication(@PathVariable("id") Long id){
        return publicationService.approvePublication(id);
    }

    @PutMapping("/likes/{id}")
    public void incrementLikes(@PathVariable("id") Long id){

        publicationService.incrementLikes(id);
    }

    @PutMapping("/shared/{id}")
    public void incrementShares(@PathVariable("id") Long id){

        publicationService.incrementShareds(id);
    }

    @PutMapping("/favorites/{id}")
    public void incrementFavorites(@PathVariable("id") Long id){

        publicationService.incrementFavorites(id);
    }

    @DeleteMapping("/{IdPublication}")
    public void delete(@PathVariable("IdPublication") Long IdPublication){

        publicationService.delete(IdPublication);
    }
}
