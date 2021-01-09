package com.clover.collections;

public class Customer implements Comparable<Customer>{
    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public int compareTo(Customer o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        /*return "Customer{" +
                "name='" + name + '\'' +
                '}';*/
        return name;
    }
}
