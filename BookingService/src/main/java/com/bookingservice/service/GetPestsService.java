package com.bookingservice.service;

import com.bookingservice.entity.Pests;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PESTSERVICE")
public interface GetPestsService {

    @GetMapping("/pests/id/{id}")
    Pests getPests(@PathVariable ObjectId id);
}
