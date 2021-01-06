package com.clover.generics;

public class KeyValuePair <K,V>{
    private K key;
    private V value;

    //construct
    public KeyValuePair(K key,V value){
        this.key = key;
        this.value = value;
    }
}
