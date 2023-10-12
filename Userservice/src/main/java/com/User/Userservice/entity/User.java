package com.User.Userservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private  int Uid;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Email")
    private String Email;
    @Column(name = "Tp")
    private  int Tp;

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getTp() {
        return Tp;
    }

    public void setTp(int tp) {
        Tp = tp;
    }
}
