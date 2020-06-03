package com.example.crowdfunding.domain;

import javax.persistence.*;

@Entity
public class Fund {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String text;
    private String tag;
    private Long goal;
    private Long current_balance;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;



    public Fund(){

    }
    public Fund(String title, String text, User user, Long goal, Long current_balance) {
        this.author = user;
        this.title = title;
        this.text = text;

        this.current_balance = current_balance;
        this.goal = goal;
    }
    public Long getGoal() {
        return goal;
    }

    public void setGoal(Long goal) {
        this.goal = goal;
    }

    public Long getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(Long current_balance) {
        this.current_balance = current_balance;
    }

    public String getAuthorName(){
        return author!=null ? author.getUsername() : "noname";
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void setTag(String tag){
        this.tag = tag;
    }
    public String getTag(){
        return tag;
    }
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
