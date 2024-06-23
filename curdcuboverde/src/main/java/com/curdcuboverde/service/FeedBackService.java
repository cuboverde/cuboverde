package com.curdcuboverde.service;

import com.curdcuboverde.entity.FeedBack;
import com.curdcuboverde.repository.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FeedBackService {
    @Autowired
    FeedBackRepository feedBackRepository;

    public List<FeedBack> getFeedBacks(){
        return feedBackRepository.findAll();
    }
    public Optional<FeedBack> getFeedBack(Long id){
        return feedBackRepository.findById(id);
    }

    public void saveOrUpdate(FeedBack feedBack){
        feedBackRepository.save(feedBack);
    }

    public void delete(Long id){
        feedBackRepository.deleteById(id);
    }
}
