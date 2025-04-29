package com.bookingservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Booking {

    @Id
    private ObjectId id;
    private ObjectId userId;
    private ObjectId pestId;

    @CreatedDate
    private Instant createdTime;
    private Status status;

    private transient Pests pests;

    public Booking(ObjectId userId, ObjectId pestId) {
        this.userId = userId;
        this.pestId = pestId;
        this.createdTime = Instant.now();
        this.status = Status.PENDING;
    }

    public enum Status {
        PENDING,        // Booking created but not yet confirmed
        CONFIRMED,      // Confirmed by service provider
        IN_PROGRESS,    // Pest control service is ongoing
        COMPLETED,      // Service completed successfully
        CANCELLED       // Booking cancelled
    }

}
