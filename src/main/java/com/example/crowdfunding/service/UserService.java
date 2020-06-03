package com.example.crowdfunding.service;

import antlr.StringUtils;
import com.example.crowdfunding.domain.Role;
import com.example.crowdfunding.domain.User;
import com.example.crowdfunding.repos.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public boolean addUser(User user){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb!=null){
            return false;
        }
        user.setActive(true);
       // user.setBalance(0L);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return true;

    }
    public void addBalance(User user,Long value){
        user.setBalance(value);
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<User> findAll() {
        return userRepo.findAll();
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void saveUser(User user, String username, Map<String, String> form, Long balance) {
        user.setUsername(username);
        user.setBalance(balance);
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void updateProfile(User user, String password, Long balance) {
        Long userBalance  = user.getBalance();
       boolean isBalanceChanged =  (balance != null && !balance.equals(userBalance));
       if (isBalanceChanged){
            user.setBalance(userBalance + balance);
       }
       user.setPassword(password);

       userRepo.save(user);
    }
    public User findById(Long Id){
        User us = userRepo.findById(Id).get();
        return us;
    }

}
