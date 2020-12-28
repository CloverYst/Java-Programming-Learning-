package com.clover;


//we don't wanna initialize UIControl or create it's instance. It should be an abstract Class
public abstract class UIControl {
    private boolean isEnabled = true;

    /*public UIControl(boolean isEnabled){
        this.isEnabled = isEnabled;
        System.out.println("UIControl");
    }*/

    //if a method has final keyword, it cannot be override by sub class suitable for when we dont wanna its behavior is changed
    public final void enable(){
        isEnabled = true;
    }
    public void disable(){
        isEnabled = false;
    }

    public boolean isEnabled(){
        return isEnabled;   //different members can have the same name one is method the other is field
    }

    //should be an abstract method
    public abstract void render();
}
