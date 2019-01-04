package com.udacity.gradle.builditbigger;

import java.util.Random;

public class MyJokes {

    private static final String[] jokes = new String[]{
            "What do you call an Alligator in a vest? An Investigator!!",
            "Whats orange and sounds like parrot? A Carrot!",
            "What do you call a dog that does magic tricks? A Labradadrador",
            "How did the hipster burn his mouth? He ate pizza before its cool"
    };
    public String getJokes(){
        Random random = new Random();
        return jokes[random.nextInt(jokes.length)];
    }
}
