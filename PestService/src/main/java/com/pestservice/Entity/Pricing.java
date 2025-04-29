package com.pestservice.Entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Pricing {

    @Id
    private ObjectId id;


    private String pricingType; //One-time / Monthly / Yearly
    private String priceDetails; // Details about the price;
    private String price;
}
