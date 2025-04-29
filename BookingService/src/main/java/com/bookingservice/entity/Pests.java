package com.bookingservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Pests {

    @Id
    private ObjectId id;

    private String pestName;
    private String pestImageUrl;
    private String pestDes;
    private String ytLink;

    public Pests() {} // No-args constructor
}
