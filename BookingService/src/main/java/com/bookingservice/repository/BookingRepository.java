package com.bookingservice.repository;

import com.bookingservice.entity.Booking;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking , ObjectId> {

    List<Booking> findBookingByUserId(ObjectId user_id);
}
