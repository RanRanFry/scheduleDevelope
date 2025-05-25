package com.example.scheduledevelope.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String email;

    // 생성자

    public User(){}

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public void changeName(String userName) {
        this.userName = userName;
    }

    public void changeEmail(String email) {
        this.email = email;
    }
}
