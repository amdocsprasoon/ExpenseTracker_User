package org.sebprojects.expensetracker_user.services;

import org.sebprojects.expensetracker.dtos.UserInfoDto;
import org.sebprojects.expensetracker_user.entities.UserDetails;
import org.sebprojects.expensetracker_user.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    public UserInfoDto saveUserDetails(UserInfoDto userInfoDto) {
        // Logic to save user details
        // For example, save to a database or perform some processing
        System.out.println("Saving user details: " + userInfoDto);

        UserDetails userDetails = UserDetails.builder()
                .userId(userInfoDto.getUserId())
                .email(userInfoDto.getEmail())
                .userName(userInfoDto.getUsername())
                .firstName(userInfoDto.getFirstName())
                .lastName(userInfoDto.getLastName())
                .phoneNumber(userInfoDto.getPhoneNumber())
                .build();

        // check if user already exists
        if (userDetailsRepository.existsByUserId(userInfoDto.getUserId())) {
            System.out.println("User already exists with ID: " + userInfoDto.getUserId());
            return null; // or throw an exception
        }

        // Save the user details to the repository
         UserDetails savedUserDetails =  userDetailsRepository.save(userDetails);

        // Optionally, you can convert the saved entity back to DTO if needed
        return UserInfoDto.builder()
                .userId(savedUserDetails.getUserId())
                .email(savedUserDetails.getEmail())
                .username(savedUserDetails.getUserName())
                .firstName(savedUserDetails.getFirstName())
                .lastName(savedUserDetails.getLastName())
                .phoneNumber(savedUserDetails.getPhoneNumber())
                .build();


    }

    public List<UserInfoDto> getAllUsers() {
        return userDetailsRepository.findAll().stream()
                .map(userDetails -> UserInfoDto.builder()
                        .userId(userDetails.getUserId())
                        .email(userDetails.getEmail())
                        .username(userDetails.getUserName())
                        .firstName(userDetails.getFirstName())
                        .lastName(userDetails.getLastName())
                        .phoneNumber(userDetails.getPhoneNumber())
                        .build())
                .collect(Collectors.toList());
    }
}

