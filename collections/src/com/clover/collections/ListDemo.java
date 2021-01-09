package com.clover.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public void show(){
        List<String> list = new ArrayList<>();

        //Add new item because List extends Collection so we can use all collection's methods
        list.add("a");
        Collections.addAll(list,"b","c","a","b");
        //list overload add() method
        list.add(0,"!");
        System.out.println(list);
        list.remove(0);
        list.set(0,"a+");//replace
        System.out.println(list);
        System.out.println(list.indexOf("b"));
        System.out.println(list.lastIndexOf("b"));
        System.out.println(list.subList(1,4));
    }
}
