package com.example.Springwithdb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//collection is default name to store mongodb collection name set
@Document(collection = "my_enterys") // -> make a document in collection in mongodb
//by default my @Document tak a MyEntery document name so pass other document name here
public class MyEntery {
    @Id //-> make as primery key
//    private String id;//default am using String as id
    /*but now am using Objectid data type as mongodb object entry id type*/
    private ObjectId id;
    private String title;
    private String content;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
