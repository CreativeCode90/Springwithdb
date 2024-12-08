package com.example.Springwithdb.controller;

import com.example.Springwithdb.model.MyEntery;
import com.example.Springwithdb.service.MyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/add")
public class MyController {
    @Autowired
    private MyService services; //get MySerive class object here using spring and run
    /*our servie here use service method like save*/
    private Map<ObjectId, MyEntery> entery = new HashMap<>();

    @PostMapping
    //create controller post method
    public boolean create(@RequestBody MyEntery data) {
        entery.put(data.getId(), data);
        //save my entery in mongodb as using service
        services.saveEntry(data); //pass data to save
        return true;
    }

    @GetMapping
    //get all list get method
    public List<MyEntery> getAll() {
        return services.getAll();
    }

    //    make a controller for get on entry fint by id
    @GetMapping("/id/{id}")
    public Optional<MyEntery> getBydId(@PathVariable ObjectId id) {
        return services.getById(id);
    }

    @DeleteMapping("id/{id}")
//    make a delete entry controller
    public Optional<MyEntery> deleteById(@PathVariable ObjectId id) {
        return services.deleteOne(id);
    }

    @GetMapping("/clear")
//    make a cntroller to delete all entry
    public Optional<MyEntery> deleteAll() {
        return services.deleteAll();
    }

    @PutMapping("/id/{id}")
    //    make a update controoler
    public MyEntery updateOne(@PathVariable ObjectId id, @RequestBody MyEntery entry) {
        Optional<MyEntery> oldEntry = services.getById(id);

        if (oldEntry.isPresent()) {
            MyEntery xentry = oldEntry.get();
            xentry.setTitle(entry.getTitle() != null & entry.getTitle().equals("") ? entry.getTitle() : entry.getTitle());
            xentry.setContent(entry.getContent() != null & entry.getContent().equals("") ? entry.getContent() : entry.getContent());
            services.saveEntry(xentry);
        }

        return entry;

    }
}
