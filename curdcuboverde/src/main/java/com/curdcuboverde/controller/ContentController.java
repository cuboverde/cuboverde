package com.curdcuboverde.controller;

import com.curdcuboverde.entity.Content;
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

    @GetMapping
    public List<Content> getAll(){
        return contentService.getContents();
    }

    @GetMapping("/{IdContent}")
    public Optional<Content> getBId(@PathVariable("IdContent") Long IdContent){
        return contentService.getContent(IdContent);
    }


    @PostMapping
    public void saveUpdate (@RequestBody Content content){
        contentService.saveOrUpdate(content);
    }

    @DeleteMapping("/{IdContent}")
    public void delete(@PathVariable("IdContent") Long IdContent){
        contentService.delete(IdContent);
    }
}
