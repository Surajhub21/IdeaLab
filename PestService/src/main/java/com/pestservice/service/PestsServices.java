package com.pestservice.service;

import com.pestservice.Entity.Pests;
import com.pestservice.repository.SavePestsMongoRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PestsServices {

    private SavePestsMongoRepository savePestsMongoRepository;

    public PestsServices(SavePestsMongoRepository savePestsMongoRepository) {
        this.savePestsMongoRepository = savePestsMongoRepository;
    }

    public Pests savePests(Pests pest){
        return savePestsMongoRepository.save(pest);
    }

    public Pests getPestsById(ObjectId id){
        return savePestsMongoRepository.findById(id).orElse(null);
    }

    public List<Pests> getAll(){
        return savePestsMongoRepository.findAll();
    }
}
