package com.pestservice.controller;

import com.cloudinary.Cloudinary;
import com.pestservice.Entity.Pests;
import com.pestservice.service.PestsServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pests")
public class PestsController {

    @Autowired
    private PestsServices pestsServices;
    @Autowired
    private Cloudinary cloudinary;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void savePost(@RequestPart Pests pests , @RequestPart MultipartFile file){

        try {
            Map upload = cloudinary.uploader().upload(file.getBytes(), Map.of());
            Object url = upload.get("secure_url");
            pests.setPestImageUrl(url.toString());
            pestsServices.savePests(pests);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping
    public List<Pests> getAll(){
        return pestsServices.getAll();
    }

    @GetMapping("/id/{id}")
    public Pests getById(@PathVariable ObjectId id){
        return pestsServices.getPestsById(id);
    }
}
