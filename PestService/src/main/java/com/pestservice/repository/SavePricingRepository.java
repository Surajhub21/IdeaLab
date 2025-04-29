package com.pestservice.repository;

import com.pestservice.Entity.Pricing;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SavePricingRepository extends MongoRepository<Pricing , ObjectId> {
}
