package org.hallabol.nunuservice.controller;

import jakarta.annotation.PostConstruct;
import org.hallabol.nunuservice.model.User;
import org.hallabol.nunuservice.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {
    private final UserInfoService userInfoService;

    public UserInfoController(final UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users =  userInfoService.getAllUsers();

        return users;
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable int userId) {
        User user =  userInfoService.getUser(userId);

        return user;
    }

    @GetMapping("/hello/{name}")
    public User getUser(@PathVariable String name) {
        return new User(
                1213,
                "Hi " + name,
                "kumar.rahul.ng@gmail.com",
                "10B s  illwood place",
                "India"
        );
    }
}
