package org.example.service;

import org.example.entity.AppUser;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AppUser saveUser(AppUser user){
        return userRepository.save(user);
    }

    public AppUser findByUsername(String username){
        return userRepository.findByUsername(username).orElse(null);
    }

    public Optional<AppUser> findByUserId(Long userId){
        return userRepository.findById(userId);
    }
}
