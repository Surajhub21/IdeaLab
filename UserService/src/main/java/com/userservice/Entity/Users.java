package com.userservice.Entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Users {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String userName;
    private String password;

    private String email;
    private String phNo;
    private String address;

    private transient List<Booking> bookings = new ArrayList<>();

}
