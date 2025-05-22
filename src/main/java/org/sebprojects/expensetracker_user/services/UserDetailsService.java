package org.sebprojects.expensetracker_user.services;

import org.sebprojects.expensetracker.dtos.UserInfoDto;
import org.sebprojects.expensetracker_user.entities.UserDetails;
import org.sebprojects.expensetracker_user.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

