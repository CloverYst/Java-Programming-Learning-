package com.clover;

//If we sure about that class is specific implement and dont wanna other class inherit it we use final
public final class CheckBox extends UIControl{
    //must implement or at least declare this method because it is an abstract method in UIControl Class
    @Override
    public void render() {
        System.out.println("render CheckBox");
    }
}
