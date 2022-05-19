package com.oran.springProject.service;

import com.oran.springProject.entity.UserEntity;
import com.oran.springProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> searchUsers(String name) {
        return userRepository.findAllByName(name);
    }

    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
