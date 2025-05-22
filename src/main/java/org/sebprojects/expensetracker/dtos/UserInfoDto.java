package org.sebprojects.expensetracker.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sebprojects.expensetracker_user.entities.Roles;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// SO it was sending the header "org.sebprojects.expensetracker.dtos.UserInfoDto" that was from the producer, so I have to make the
// same path in this Consumer Microservice, this is not a good practice, but it is a test
public class UserInfoDto {

    private Long userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private Set<Roles> roles;
}
