package com.curdcuboverde.service;

import com.curdcuboverde.entity.Record;
import com.curdcuboverde.repository.RecordRepository;
import com.curdcuboverde.repository.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RecordService {
    @Autowired
    RecordRepository recordRepository;
    @Autowired
    private FeedBackRepository feedBackRepository;

    public List<Record> getRecords(){

        return recordRepository.findAll();
    }
    public Optional<Record> getRecord(Long id){

        return recordRepository.findById(id);
    }

    public void saveOrUpdate(Record record){
        if(feedBackRepository.findById(record.getIdFeedBack()).isPresent()){
            recordRepository.save(record);
        }else {
            return;
        }

    }

    public void updateRecord(Long id, Record record){
        if(feedBackRepository.findById(record.getIdFeedBack()).isPresent()){
            Record updateRec = recordRepository.findById(id).get();

            updateRec.setIdFeedBack(record.getIdFeedBack());
            updateRec.setRecord(record.getRecord());
            updateRec.setDescriptionRecord(record.getDescriptionRecord());

            recordRepository.save(updateRec);

        }
    }

    public void delete(Long id){

        recordRepository.deleteById(id);
    }

}
