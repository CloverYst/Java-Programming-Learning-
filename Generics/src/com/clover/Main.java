package com.clover;

import com.clover.generics.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var list = new List();
        list.add(1);//can only store integer item

        //one way to solve it is to use Object because it is parent of all reference types
        var listObject = new ListObject();
        listObject.add(1);//can add a primitive type cuz Integer.valueOf(1)
        listObject.add("1");
        listObject.add(new User(12));//can add any type
        int number1 = (int) listObject.get(0);

        //Better way is use Generic Class
        var items = new GenericList<User>();//should specific the type here
        items.add(new User(11));


        //cannot use primitive types directly in Generic Class we should use it wrapper Class
        //new GenericList<int/float/boolean> (); that is not right
        //int->Integer float->Float boolean->Boolean
        //GenericList<Integer> numbers = new GenericList<Integer>();  we dont need the second Integer
        GenericList<Integer> numbers = new GenericList<>();
        numbers.add(1);
        int number2 = numbers.get(0);


        //compare two Users
        var user1 = new User(10);
        var user2 = new User(20);
        if(user1.compareTo(user2)<0)
            System.out.println("user1 < user2");
        else if (user1.compareTo(user2)==0)
            System.out.println("user1 == user2");
        else
            System.out.println("user1 > user2");

        //Use Generic Method
        System.out.println(Utils.max(user1,user2));

        //Use multiple type Generic parameters method
        Utils.print(1,"first");

        //Generic class and Inheritance
        //if have a variable of type User, can set it to an instance of User or any it's derivatives like Instructor
        User user = new Instructor(10);// User user = new User(10);

        //GenericList<Instructor> is not an subtype of GenericList<User> because we are dealing with a single class
        //var users = new GenericList<Instructor>();  Utils.printUsers(users); there will be an compiler error
        var users = new GenericList<User>();
        Utils.printUsers(users);
        //one way to solve it is : from list of instructor to users, then iterator over the list of Instructors and add
        //each instructor object to the list of users

        //A better way to solve the problem on the top is use wildcard



    }
}
