package com.clover.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public void show(){
        Collection<String> collection = new ArrayList<>();

        //first way to add
        collection.add("a");
        collection.add("b");
        collection.add("c");

        //instead use add several times we can use addAll() method to add all at one time
        Collections.addAll(collection,"e","f","g");

        //use for each loop
        for (var item : collection)
            System.out.println(item);

        //or we can print the whole collection
        System.out.println(collection);

        //other useful methods
        collection.remove("a");
        //collection.clear();
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println(collection.contains("c"));

        //toArray() method : there are three overloads
        Object[] objectArrays = collection.toArray();
        String[] stringArrays = collection.toArray(new String[0]);// String[collection size] but java will automatically give the enough space

        //compare two collection
        Collection<String> other = new ArrayList<>();
        other.addAll(collection);
        System.out.println(collection == other);//we will get false because they are two different objects in memory
        //that == compares reference
        System.out.println(collection.equals(other));//this will return true these two has the exact same contains
    }
}
