package com.bookingservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Setter
@Getter
public class RequestBodyPOJO {

    private ObjectId user_id;
    private ObjectId pest_id;

    public RequestBodyPOJO(ObjectId user_id, ObjectId pest_id) {
        this.user_id = user_id;
        this.pest_id = pest_id;
    }
}
