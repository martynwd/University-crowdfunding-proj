package com.example.crowdfunding.service;

import com.example.crowdfunding.domain.Fund;
import com.example.crowdfunding.domain.User;
import com.example.crowdfunding.repos.FundRepo;
import com.example.crowdfunding.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FundRepo fundRepo;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public boolean processTransaction(Long senderId, Long recipientId, Long amount){
       User sender = userRepo.findById(senderId).get();
       Fund recipient = fundRepo.findById(recipientId).get();
        if(sender.getBalance() - amount >= 0){
            sender.setBalance(sender.getBalance() - amount);
            recipient.setCurrent_balance(recipient.getCurrent_balance() + amount);
            fundRepo.save(recipient);
            userRepo.save(sender);
            return true;
        }
        else {
            return false;
        }


    }
}
