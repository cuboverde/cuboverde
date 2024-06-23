package com.curdcuboverde.controller;

import com.curdcuboverde.entity.FeedBack;
import com.curdcuboverde.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/feedback")
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @GetMapping
    public List<FeedBack> getAll(){
        return feedBackService.getFeedBacks();
    }

    @GetMapping("/{IdFeedBack}")
    public Optional<FeedBack> getBId(@PathVariable("IdFeedBack") Long IdFeedBack){
        return feedBackService.getFeedBack(IdFeedBack);
    }


    @PostMapping
    public void saveUpdate (@RequestBody FeedBack feedBack){
        feedBackService.saveOrUpdate(feedBack);
    }

    @DeleteMapping("/{IdFeedBack}")
    public void delete(@PathVariable("IdFeedBack") Long IdFeedBack){
        feedBackService.delete(IdFeedBack);
    }
}
