package org.example.service;

import org.example.dto.UserHomePageDto;
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

    public UserHomePageDto loadHomePage(String username){
        AppUser appUser = findByUsername(username);
        UserHomePageDto homePageDto = new UserHomePageDto();

        homePageDto.setUserId(appUser.getUserId());
        homePageDto.setFirstname(appUser.getFirstname());
        homePageDto.setLastname(appUser.getLastname());
        homePageDto.setUsername(appUser.getUsername());
        homePageDto.setBirthday(appUser.getBirthdate());
        homePageDto.setEmail(appUser.getEmail());

        return homePageDto;
    }
}
