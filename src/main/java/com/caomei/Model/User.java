package com.caomei.Model;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.*;

/**
 * @author 🍓
 * create in 2023/5/19 15:39
 * 我想干嘛：
 */
@Repository
@Table(name = "mango_user")
public class User {
    @Id
    @Column(name = "user_id")
    private int ID;
    @Column(name = "user_nickname")
    private String name;

    public User() {
    }

    public User(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
