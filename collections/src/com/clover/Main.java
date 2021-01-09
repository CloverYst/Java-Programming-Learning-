package com.clover;

import com.clover.collections.*;
import com.clover.generics.GenericList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //need to use iterable interface: internal implementation detail change
        var list = new GenericList<String>();
        list.add("a");
        list.add("b");
        //for(var item: list.items)  need to change the items to public which will expose the internal detail to outside

        //fix the pro on the top use iterator method
        //[a,b,c]
        //       ^ iterator like a pointer
        var iterator = list.iterator();
        while(iterator.hasNext()){
            var current = iterator.next();
            System.out.println(current);
        }


        //iterate the list use for each loop because already has the private class ListIterator inside GenericList
        for(var item : list){
            System.out.println(item);
        }


        //Collection Interface
        new CollectionsDemo().show();

        //List Interface
        new ListDemo().show();

        //Comparable Interface
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("b", "e3"));
        customers.add(new Customer("a", "e2"));
        customers.add(new Customer("c", "e1"));
        Collections.sort(customers);
        System.out.println(customers);
        Collections.sort(customers,new EmailComparator());
        System.out.println(customers);

        //Queue Interface
        new QueueDemo().show();

        //Set Interface
        new SetDemo().show();

        //Map Interface
        MapDemo.show();
    }
}
