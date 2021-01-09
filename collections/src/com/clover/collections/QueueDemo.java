package com.clover.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public void show(){
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.offer("a");//if queue is full, add() throw exception while offer() returns false
        queue.add("b");

        var front = queue.peek();
        //var front = queue.element();  //if queue empty,peek() returns null, element() throws exception
        System.out.println(front);

        queue.remove();//remove the front item and return it
        //queue.poll();//if queue empty, remove() throws exception, poll() returns null
        System.out.println(queue);
    }
}
