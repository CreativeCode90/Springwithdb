package com.example.Springwithdb.service;

import com.example.Springwithdb.model.MyEntery;
import com.example.Springwithdb.reposetery.Myrepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyService {
    @Autowired
    //use myrepo using like this
    private Myrepo mongorepo;

//    make a method to save entery
    public void saveEntry(MyEntery myEntery){
//        to save my entery using mongodb method indirecty by using my repo
        mongorepo.save(myEntery); // -> use save method to save
    }

//    make a get all service in mongodb we have a findAll() method
    public List<MyEntery> getAll(){
       return  mongorepo.findAll();
    }


//    make a getOne service  which is get only one entry from mongodb
//use fndOne() method and give which field data you want to find
    public Optional<MyEntery> getById(ObjectId id){
        return mongorepo.findById(id);
    }
//    make a delete one entery by get entery id
//    in mongodb we have a method to delete like deleteOne() & deleteMany()
//    delete one entry use deleteOne()
//    🐬
//    but in thie springboot we hve two method to delete entry like
//    deleteById()  && deleteAll()

    public Optional<MyEntery> deleteOne(ObjectId id){
        Optional<MyEntery> entry = mongorepo.findById(id);
        entry.ifPresent(e -> mongorepo.deleteById(id));
        return entry;
    }

//    delete all servie method
    public Optional<MyEntery> deleteAll(){
        List<MyEntery> entry = mongorepo.findAll();
        if(!entry.isEmpty()){
            mongorepo.deleteAll();
            Optional.of(entry);
        }
        return Optional.empty();
    }

//    do update one entry
//







}
