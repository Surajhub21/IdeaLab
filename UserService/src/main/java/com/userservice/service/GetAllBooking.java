package com.userservice.service;

import com.userservice.Entity.Booking;
import com.userservice.Entity.RequestBodyPOJO;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "BOOKINGSERVICE")
public interface GetAllBooking {

    @PostMapping("/booking")
    public Booking bookAnService(@RequestBody RequestBodyPOJO pojo);

    @GetMapping("/booking/id/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable ObjectId userId);

    @DeleteMapping("/booking/id/{id}")
    public void deleteAnService(@PathVariable ObjectId id);
}
