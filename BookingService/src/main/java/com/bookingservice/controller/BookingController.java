package com.bookingservice.controller;

import com.bookingservice.entity.Booking;
import com.bookingservice.entity.RequestBodyPOJO;
import com.bookingservice.service.BookingService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> bookAnService(@RequestBody RequestBodyPOJO body){
        Booking booked = new Booking(body.getUser_id() , body.getPest_id());
        return new ResponseEntity<>(bookingService.bookAService(booked) , HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @GetMapping("/id/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable ObjectId userId){
        return bookingService.getBookingsByUserId(userId);
    }

    @DeleteMapping("/id/{id}")
    public void deleteAnService(@PathVariable ObjectId id){
        bookingService.deleteById(id);
    }
}
