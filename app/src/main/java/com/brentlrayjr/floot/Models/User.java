package com.brentlrayjr.floot.Models;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by blray on 11/25/2015.
 */

@JsonObject
public class User {

    @JsonField
    private String username;

    @JsonField()
    private String email;

    private String password;

    @JsonField()
    private boolean isAdmin;

    private ArrayList<Floot> floots;
    public ArrayList<Reply> replies;


    public User(String email, String username, String password) {

        this.email = email;
        this.username = username;
        this.password = password;
        this.isAdmin = false;


    }


    public User() {
    }

    public User(User user) {
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {

        return this.isAdmin;
    }

    public ArrayList<Floot> getFloots() {
        return floots;
    }

    public ArrayList<Reply> getReplies() {
        return replies;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFloots(ArrayList<Floot> floots) {
        this.floots = floots;
    }

    public void setServices(ArrayList<Reply> replies) {
        this.replies = replies;
    }

    public String generateString() {

        String result = "";
        Random random = new Random();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < 6; i++) {

            int number = random.nextInt((25 - 0) + 1) + 0;


            result += alphabet[number];

            number = random.nextInt((9 - 0) + 1) + 0;
            result += number;


        }


        return result;
    }

}
