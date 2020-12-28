package com.clover;

public class TextBox extends UIControl{
    private String text ="";

    /*public TextBox() {
        //super(true);
        System.out.println("TextBox");
    }*/

    public void setText(String text){
        this.text = text;
    }

    public void clear(){
        this.text = "";
    }

    //overriding parent Object method toString
    @Override
    public String toString(){
        return text;
    }

    @Override
    public void render() {
        System.out.println("render TextBox");
    }

}
