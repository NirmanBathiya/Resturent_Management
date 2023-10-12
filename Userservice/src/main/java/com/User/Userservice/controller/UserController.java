package com.User.Userservice.controller;

import com.User.Userservice.response.UserReponse;
import com.User.Userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private UserService userService;

    @GetMapping("order/id")
    private ResponseEntity<UserReponse> getUserDetails(@PathVariable("id") int id){
        UserReponse User = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(User);

    }
}
