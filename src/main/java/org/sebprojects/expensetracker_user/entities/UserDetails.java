package org.sebprojects.expensetracker_user.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserDetails {

    @Id
    Long userId;
    String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
