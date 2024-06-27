package com.curdcuboverde.service;

import com.curdcuboverde.entity.FeedBack;
import com.curdcuboverde.repository.FeedBackRepository;
import com.curdcuboverde.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FeedBackService {
    @Autowired
    FeedBackRepository feedBackRepository;
    @Autowired
    private UserRepository userRepository;

    public List<FeedBack> getFeedBacks(){

        return feedBackRepository.findAll();
    }
    public Optional<FeedBack> getFeedBack(Long id){

        return feedBackRepository.findById(id);
    }

    public void saveOrUpdate(FeedBack feedBack){

        feedBackRepository.save(feedBack);
    }

    public Optional<FeedBack> updateFeedback(Long id, FeedBack feedBack){
        if(userRepository.findById(feedBack.getIdUser()).isPresent()){
            FeedBack updateFeedback = feedBackRepository.findById(id).get();

            updateFeedback.setFeedBackDate(feedBack.getFeedBackDate());
            updateFeedback.setIdUser(feedBack.getIdUser());
            updateFeedback.setTypeFeedBack(feedBack.getTypeFeedBack());
            updateFeedback.setDescriptionFeedBack(feedBack.getDescriptionFeedBack());

            feedBackRepository.save(updateFeedback);
            return feedBackRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }

    public void delete(Long id){
        feedBackRepository.deleteById(id);
    }
}
