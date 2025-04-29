package com.bookingservice.service;

import com.bookingservice.entity.Booking;
import com.bookingservice.repository.BookingRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private GetPestsService getPestsService;

    BookingService(BookingRepository bookingRepository, GetPestsService getPestsService){
        this.bookingRepository = bookingRepository;
        this.getPestsService = getPestsService;
    }

    public Booking bookAService(Booking booked){

        return bookingRepository.save(booked);

    }

    public List<Booking> getBookingsByUserId(ObjectId userId){
        List<Booking> bookingByUserId = bookingRepository.findBookingByUserId(userId);
        bookingByUserId.forEach(it ->
                it.setPests(getPestsService.getPests(it.getPestId()))
                );
        return bookingByUserId;
    }

    public List<Booking> getAllBooking(){
        List<Booking> bookingList = bookingRepository.findAll();
        bookingList.forEach(it ->
                it.setPests(getPestsService.getPests(it.getPestId()))
                );
        return bookingList;
    }

    public void deleteById(ObjectId id){
        bookingRepository.deleteById(id);
    }
}
