package com.pestservice.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProjectConfig {

    @Bean
    public Cloudinary getCloudinary(){

        Map map = new HashMap();
        map.put("cloud_name" , "dnlwi1h2h");
        map.put("api_key" , "717925727237118");
        map.put("api_secret" , "kgcql6fawVsQUzg_3qNnwSCngPA");

        return new Cloudinary(map);
    }
}
