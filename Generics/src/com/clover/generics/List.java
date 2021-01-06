package com.clover.generics;


//This Class can only used to create a list to store integrate if we want to store User info we can't.
public class List {
    private int[] items = new int[10];
    private int count;

    public void add(int item){
        items[count++] = item;
    }
    public int get(int index){
        return items[index];
    }

}
