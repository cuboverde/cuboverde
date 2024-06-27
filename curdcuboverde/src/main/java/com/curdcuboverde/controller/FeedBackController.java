package com.curdcuboverde.controller;

import com.curdcuboverde.entity.FeedBack;
import com.curdcuboverde.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<FeedBack> getAll(){

        return feedBackService.getFeedBacks();
    }

    @GetMapping("/{IdFeedBack}")
    public Optional<FeedBack> getBId(@PathVariable("IdFeedBack") Long IdFeedBack){
        return feedBackService.getFeedBack(IdFeedBack);
    }


    @PostMapping
    public Optional<FeedBack> saveUpdate (@RequestBody FeedBack feedBack){
        if(userRepository.findById(feedBack.getIdUser()).isPresent()){
            feedBackService.saveOrUpdate(feedBack);
            return feedBackService.getFeedBack(feedBack.getIdFeedBack());
        }else{
            return Optional.empty();
        }

    }

    @PutMapping("modificar/{id}")
    public Optional<FeedBack> update(@PathVariable("id") Long id, @RequestBody FeedBack feedBackModel){
        if (feedBackService.getFeedBack(id).isPresent()) {
            feedBackService.updateFeedback(id, feedBackModel);
            return feedBackService.getFeedBack(id);
        }else {
            return Optional.empty();
        }

    }

    @DeleteMapping("/{IdFeedBack}")
    public void delete(@PathVariable("IdFeedBack") Long IdFeedBack){

        feedBackService.delete(IdFeedBack);
    }
}
