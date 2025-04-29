package com.userservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "*")
public class HomeController {

    public String home(){
        return "index.html";
    }
}
