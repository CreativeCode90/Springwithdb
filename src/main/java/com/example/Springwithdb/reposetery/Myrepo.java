package com.example.Springwithdb.reposetery;

import com.example.Springwithdb.model.MyEntery;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Myrepo extends MongoRepository<MyEntery , ObjectId> {
}
