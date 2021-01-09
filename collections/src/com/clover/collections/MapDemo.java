package com.clover.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
    public static void show(){
        List<Customer> cutomers = new ArrayList<>();

        //O(n)
        for (var item : cutomers){
            if(item.getEmail()=="e1")
                System.out.println("Found!");
        }//not ideal way to do , better way is use hashtable

        Customer c1= new Customer("c1","e1");
        Customer c2= new Customer("c2","e2");

        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(),c1);
        map.put(c2.getEmail(),c2);

        var customer = map.get("e1");
        System.out.println(customer);

        //useful methods
        var unknow = new Customer("unknow","");
        var customer1 = map.getOrDefault("e10",unknow);
        System.out.println(customer1);

        var exits = map.containsKey("e10");
        System.out.println(exits);

        map.replace("e1",new Customer("a++","e1"));
        System.out.println(map);

        //map is not iterable cannot use for each loop
        for (var key: map.keySet())
            System.out.println(key);
        for (var entry: map.entrySet())
            System.out.println(entry);
        for (var cus: map.values())
            System.out.println(cus);
    }
}
