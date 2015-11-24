package com.brentlrayjr.floot.Models;

import java.util.Random;

/**
 * Created by blray on 11/23/2015.
 */
public class Post<T> {

    T content;
    int upVotes;
    int downVotes;
    int length;



    public Post() {

        content = null;
        length=generateLength();

    }

    public Post(T content){

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
