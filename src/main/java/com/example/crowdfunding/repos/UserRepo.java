package com.example.crowdfunding.repos;

import com.example.crowdfunding.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository <User, Long> {
    //User findById()
    User findByUsername(String username);


}
