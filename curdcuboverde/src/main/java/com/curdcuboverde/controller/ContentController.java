package com.curdcuboverde.controller;

import com.curdcuboverde.entity.Content;
import com.curdcuboverde.repository.PublicationRepository;
import com.curdcuboverde.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/contents")
public class ContentController {
    @Autowired
    private ContentService contentService;
    @Autowired
    private PublicationRepository publicationRepository;

    @GetMapping
    public List<Content> getAll(){
        return contentService.getContents();
    }

    @GetMapping("/{IdContent}")
    public Optional<Content> getBId(@PathVariable("IdContent") Long IdContent){
        return contentService.getContent(IdContent);
    }


    @PostMapping
    public Optional<Content> saveUpdate (@RequestBody Content content){
        if(publicationRepository.findById(content.getIdPublication()).isPresent()){
            contentService.saveOrUpdate(content);
            return contentService.getContent(content.getIdContent());
        }else{
            return Optional.empty();
        }

    }

    @PutMapping("/modificar/{id}")
    public Optional<Content> update(@PathVariable("id") Long id, @RequestBody Content content){
        if(publicationRepository.findById(content.getIdPublication()).isPresent()){
            contentService.updateContent(id, content);
            return contentService.getContent(id);
        }else{
            return Optional.empty();
        }
    }

    @DeleteMapping("/{IdContent}")
    public void delete(@PathVariable("IdContent") Long IdContent){

        contentService.delete(IdContent);
    }
}
