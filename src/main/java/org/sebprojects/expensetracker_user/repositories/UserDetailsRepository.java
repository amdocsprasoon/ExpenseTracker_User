package org.sebprojects.expensetracker_user.repositories;


import org.sebprojects.expensetracker_user.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    boolean existsByUserId(Long userId);
}
