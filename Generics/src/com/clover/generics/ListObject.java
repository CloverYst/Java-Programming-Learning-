package com.clover.generics;

public class ListObject {
    private Object[] items = new Object[10];
    private int count;

    public void add(Object item){
        items[count++] = item;
    }
    public Object get(int index){
        return items[index];
    }
}
