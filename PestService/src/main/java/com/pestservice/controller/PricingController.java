package com.pestservice.controller;

import com.pestservice.Entity.Pests;
import com.pestservice.Entity.Pricing;
import com.pestservice.service.PestsServices;
import com.pestservice.service.PricingService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price")
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @PostMapping
    public void savePrice(@RequestBody Pricing pricing){
        pricingService.savePrice(pricing);
    }

    @GetMapping
    public List<Pricing> getAll(){
        return pricingService.getAll();
    }

    @GetMapping("/d/id")
    public void getById(@RequestParam ObjectId id){
        pricingService.deletePriceDetails(id);
    }
}
