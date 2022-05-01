package com.oran.springProject.controller;

import com.oran.springProject.client.CurrencyClient;
import com.oran.springProject.model.User;
import com.oran.springProject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final CurrencyClient currencyClient;

    public UserController(UserService userService, CurrencyClient currencyClient) {
        this.userService = userService;
        this.currencyClient = currencyClient;
    }

    @GetMapping
    public List<String> searchUsers(@RequestParam(name = "name", required = false, defaultValue = "") String name){
        currencyClient.getCurrency();
        return userService.searchUsers(name);
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id){
        return null;
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        return null;
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        return null;
    }



}
