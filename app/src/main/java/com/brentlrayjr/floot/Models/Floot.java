package com.brentlrayjr.floot.Models;

import java.util.Random;

public class Floot<T> {

    T content;
    int upVotes;
    int downVotes;
    int length;


    public Floot() {

        content = null;
        length=generateLength();

    }

    public Floot(T content) {

        this.content = content;
        this.length = generateLength();

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
