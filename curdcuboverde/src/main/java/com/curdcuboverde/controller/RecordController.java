package com.curdcuboverde.controller;

import com.curdcuboverde.entity.Record;
import com.curdcuboverde.repository.FeedBackRepository;
import com.curdcuboverde.repository.RecordRepository;
import com.curdcuboverde.repository.UserRepository;
import com.curdcuboverde.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/records")
public class RecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FeedBackRepository feedBackRepository;
    @Autowired
    private RecordRepository recordRepository;

    @GetMapping
    public List<Record> getAll(){
        return recordService.getRecords();
    }

    @GetMapping("/{IdRecord}")
    public Optional<Record> getBId(@PathVariable("IdRecord") Long IdRecord){
        return recordService.getRecord(IdRecord);
    }

    @PostMapping
    public Optional<Record> saveUpdate (@RequestBody Record record){
        if(feedBackRepository.findById(record.getIdFeedBack()).isPresent()) {
            recordService.saveOrUpdate(record);
            return recordService.getRecord(record.getIdRecord());
        }else{
            return Optional.empty();
        }
    }

    @PutMapping("/modificar/{id}")
    public Optional<Record> Update(@PathVariable("id") Long id, @RequestBody Record record){
        if(recordService.getRecord(id).isPresent()){
            recordService.updateRecord(id, record);
            return recordService.getRecord(id);
        }else{
            return Optional.empty();
        }


    }

    @DeleteMapping("/{IdRecord}")
    public void delete(@PathVariable("IdRecord") Long IdRecord){

        recordService.delete(IdRecord);
    }
}
