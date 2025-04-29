package com.pestservice.repository;

import com.pestservice.Entity.Pests;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SavePestsMongoRepository extends MongoRepository<Pests , ObjectId> {
}
