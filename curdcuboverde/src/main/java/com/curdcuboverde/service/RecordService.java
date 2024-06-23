package com.curdcuboverde.service;

import com.curdcuboverde.entity.Record;
import com.curdcuboverde.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RecordService {
    @Autowired
    RecordRepository recordRepository;

    public List<Record> getRecords(){
        return recordRepository.findAll();
    }
    public Optional<Record> getRecord(Long id){
        return recordRepository.findById(id);
    }

    public void saveOrUpdate(Record role){
        recordRepository.save(role);
    }

    public void delete(Long id){
        recordRepository.deleteById(id);
    }

}
