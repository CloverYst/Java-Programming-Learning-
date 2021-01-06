package com.clover.generics;

public class User implements Comparable<User>{
    private int points;

    public User(int points){
        this.points = points;
    }

    //if not specific the type <T> at the top the parameter type here will automatically be Object
    @Override
    public int compareTo(User other) {
        /*if (points < other.points)
            return -1; //when less return a negative value whatever -1 or -2...
        if (points == other.points)
            return 0;
        return 1; //when lager return positive number*/

        return points - other.points;
    }

    //otherwise will return hashcode when compare two users instance and return the lager one
    @Override
    public String toString(){
        return "Points = "+ points;
    }
}
