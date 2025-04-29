package com.userservice.controller;

import com.userservice.Entity.Booking;
import com.userservice.Entity.RequestBodyPOJO;
import com.userservice.service.UsersBookingService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UsersBookingService usersBookingService;

    public UserController(UsersBookingService usersBookingService) {
        this.usersBookingService = usersBookingService;
    }

    @PostMapping
    public Booking bookedService(@RequestBody RequestBodyPOJO pojo){
        return usersBookingService.bookService(pojo);
    }

    @GetMapping("/id/{userId}")
    public List<Booking> getBooking(@PathVariable ObjectId userId){
        return usersBookingService.getBookedServices(userId);
    }

    @DeleteMapping("/id/{bookingId}")
    public void deleteBooking(@PathVariable ObjectId bookingId){
        usersBookingService.deleteAnBooking(bookingId);
    }
}
