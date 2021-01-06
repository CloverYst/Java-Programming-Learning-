package com.clover.generics;

public class Utils {
    //we can create a generic method in an un-generic Class
    //use static so we dont need to create an instance and can use this method
    public static <T extends Comparable<T>> T max (T first, T second){
        return (first.compareTo(second) < 0) ? second : first;
    }

    //method with multiple type parameters
    public static <K,V> void print(K key, V value){
        System.out.println(key + "=" + value);
    }

    public static void printUser(User user){
        System.out.println(user);
    }

    /*public static void printUsers(GenericList<User> users){

    }*/
    //WildCard
    // class CAP#1{}   actually, it create a class here and the base type is Object
    //we wanna this method only be used for User or its subclass so <? extends User>
    //class CAP#1{} extends User {}
    //Class Instructor extends User {}
    public static void printUsers(
            GenericList<? extends User> users){
        Object x = users.get(0);
    }//if use the extends keyword, User is the parent of the CAP? so we can only read but not write
    //get is ok but not add
    public static void printUsersW(
            GenericList<? super User> users){
        Object x = users.get(0);
        //User y = users.get(0); cannot read
        users.add(new User(0));
        users.add(new Instructor(1));//but can write
    }

}
