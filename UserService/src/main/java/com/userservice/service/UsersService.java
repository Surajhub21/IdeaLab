package com.userservice.service;

import com.userservice.Entity.Users;
import com.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users createUser(Users user){
        return userRepository.save(user);
    }

    public Users findUser(String userName){
        return userRepository.findByUserName(userName);
    }

}
