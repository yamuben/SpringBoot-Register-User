package com.example.demo.controller;

import com.example.demo.utils.Error;
import com.example.demo.model.User;
import com.example.demo.service.UserServices;
import com.example.demo.utils.Success;
import com.example.demo.utils.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserServices userServices;
//    @Autowired

    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        Password utils = new Password();


        String password = utils.passwordEncrypt(user.getPassword(), user.getAge());
        user.setPassword(password);


        return new ResponseEntity<>(userServices.registerUser(user), HttpStatus.CREATED);

    }
    @PostMapping("/register/map")
    public ResponseEntity<Object> createUserMap(@RequestBody User user){
        Password utils = new Password();

        if(utils.isPasswordStrong(user.getPassword())){

            String password = utils.passwordEncrypt(user.getPassword(), user.getAge());
            user.setPassword(password);

            Success success = new Success("Successfully registered",200,userServices.UserLinkedHashMap(user));
            return new ResponseEntity<>(success, HttpStatus.CREATED);

        }
        Error error = new Error("Failed to register, Weak password", 400);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);



    }

}
