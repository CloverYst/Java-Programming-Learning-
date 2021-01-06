package com.clover.generics;

/*can also add some constraints on the Generic like <T extends Number>
then when new GenericList<there must be Number class or its subclass>
it can also extends interface or multiple interfaces
popular is <T extends Comparable & Cloneable>
 */
public class GenericList <T>{
    //private T[] items = new T[10]; //The compiler can not recognize the T type
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item){
        items[count++] = item;
    }
    public T get(int index) {
        return items[index];
    }
}
