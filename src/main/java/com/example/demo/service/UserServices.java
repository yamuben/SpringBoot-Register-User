package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;


    private Map<Integer,User> userData= new LinkedHashMap<Integer, User>();
    private Integer key =1;


    public User registerUser(User user){
        return userRepository.save(user);
    }

    public Object UserLinkedHashMap (User user){
        userData.put(key,user);
        key+=1;

        return userData.values();
    }


}
