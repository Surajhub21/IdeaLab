package com.userservice.repository;


import com.userservice.Entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<Users , ObjectId> {

    Users findByUserName(String userName);

    void deleteByUserName(String name);
}
