package com.userservice.controller;

import com.userservice.Entity.Users;
import com.userservice.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Slf4j
public class PublicController {

    private UsersService usersService;

    public PublicController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String healthCheck(){
        return "Ok";
    }

    @PostMapping("/signup")
    public ResponseEntity<Users> signUpUser(@RequestBody Users user){

        try {
            return new ResponseEntity<>(usersService.createUser(user) , HttpStatus.ACCEPTED);
        }
        catch (Exception e)
        {
            log.error("Error while signupUser " + e);
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Users> loginUser(@RequestBody Users user){
        try {
            Users getUser = usersService.findUser(user.getUserName());

            if(getUser != null){
                if(user.getPassword().equals(getUser.getPassword())){
                    return new ResponseEntity<>(getUser , HttpStatus.ACCEPTED);
                }
                else {
                    log.info("User Password Didn't Match");
                    return new ResponseEntity<>(getUser , HttpStatus.FORBIDDEN);
                }
            }
            else {
                log.info("UserName not found!");
                return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e)
        {
            log.error("Error while loginUser " + e);
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }
    }
}
