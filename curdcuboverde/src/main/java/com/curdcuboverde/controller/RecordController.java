package com.curdcuboverde.controller;

import com.curdcuboverde.entity.Record;
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

    @GetMapping
    public List<Record> getAll(){
        return recordService.getRecords();
    }

    @GetMapping("/{IdRecord}")
    public Optional<Record> getBId(@PathVariable("IdRecord") Long IdRecord){
        return recordService.getRecord(IdRecord);
    }

    @PostMapping
    public void saveUpdate (@RequestBody Record record){
        recordService.saveOrUpdate(record);
    }

    @DeleteMapping("/{IdRecord}")
    public void delete(@PathVariable("IdRecord") Long IdRecord){
        recordService.delete(IdRecord);
    }
}
