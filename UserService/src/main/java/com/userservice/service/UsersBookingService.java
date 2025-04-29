package com.userservice.service;

import com.userservice.Entity.Booking;
import com.userservice.Entity.RequestBodyPOJO;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersBookingService {

    private GetAllBooking getAllBooking;

    UsersBookingService(GetAllBooking getAllBooking){
        this.getAllBooking = getAllBooking;
    }

    public Booking bookService(RequestBodyPOJO pojo){
        return getAllBooking.bookAnService(pojo);
    }

    public List<Booking> getBookedServices(ObjectId userId){
        return getAllBooking.getBookingsByUserId(userId);
    }

    public void deleteAnBooking(ObjectId bookingId){
        getAllBooking.deleteAnService(bookingId);
    }
}
