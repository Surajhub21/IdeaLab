package com.pestservice.Entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
