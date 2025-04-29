package com.pestservice.service;

import com.pestservice.Entity.Pests;
import com.pestservice.Entity.Pricing;
import com.pestservice.repository.SavePestsMongoRepository;
import com.pestservice.repository.SavePricingRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {

    private SavePricingRepository savePricingRepository;

    public PricingService(SavePricingRepository savePricingRepository) {
        this.savePricingRepository = savePricingRepository;
    }

    public Pricing savePrice(Pricing pricing){
        return savePricingRepository.save(pricing);
    }

    public List<Pricing> getAll(){
        return savePricingRepository.findAll();
    }

    public void deletePriceDetails(ObjectId id){
        savePricingRepository.deleteById(id);
    }
}
