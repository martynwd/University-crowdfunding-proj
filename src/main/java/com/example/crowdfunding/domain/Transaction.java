package com.example.crowdfunding.domain;


import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private  User sender;
    @OneToOne
    private Fund recipient;

    private Long amount;

    public Transaction(User sender_, Fund recipient_, Long amount_){
        this.sender = sender_;
        this.recipient = recipient_;
        this.amount = amount_;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Fund getRecipient() {
        return recipient;
    }

    public void setRecipient(Fund recipient) {
        this.recipient = recipient;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction(){}
}
