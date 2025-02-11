package org.example.service;

import org.example.dto.UserEditionDto;
import org.example.dto.UserHomePageDto;
import org.example.entity.AppUser;
import org.example.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        return userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
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

    public boolean updateUser(String username, UserEditionDto userEditionDto){
        AppUser existingAppUser = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
        if(!existingAppUser.getUsername().equals(userEditionDto.getUsername())){
            if(userRepository.findByUsername(userEditionDto.getUsername()).isPresent()){
                return false;
            }
            existingAppUser.setUsername(userEditionDto.getUsername());
        }
            existingAppUser.setLastname(userEditionDto.getLastname());
            existingAppUser.setFirstname(userEditionDto.getFirstname());
            existingAppUser.setBirthdate(userEditionDto.getBirthday());
            existingAppUser.setEmail(userEditionDto.getEmaill());
            userRepository.save(existingAppUser);
            return true;

    }
}
