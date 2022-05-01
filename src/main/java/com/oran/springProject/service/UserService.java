package com.oran.springProject.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final List<String> users = List.of("neri", "oran", "haim");

    public List<String> searchUsers(String name) {
        return users.stream()
                .filter(user -> user.startsWith(name))
                .collect(Collectors.toList());
    }
}
