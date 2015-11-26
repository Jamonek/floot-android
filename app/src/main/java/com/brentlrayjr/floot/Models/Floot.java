package com.brentlrayjr.floot.Models;

import java.util.ArrayList;
import java.util.Random;

public class Floot<T> {

    T content;
    int upVotes;
    int downVotes;
    int length;
    ArrayList<Reply> replies;


    public Floot() {

        content = null;
        length=generateLength();
        replies = null;

    }

    public Floot(T content) {

        this.content = content;
        this.length = generateLength();
        replies = new ArrayList<>();

    }


    public void upVote(){

        if (this.length+2 <= 45){
            this.length += 2;
        }



    }

    public void downVote(){

        if (this.length+2 <= 45){
            this.length += 2;
        }

    }

private int generateLength(){
    Random random = new Random();





    return random.nextInt((7 - 5) + 1) + 5;
}

}
