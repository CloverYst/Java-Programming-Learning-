package com.clover;

public class TextBox {  //creating class
    public String text = ""; //Field better to initialize the text because default is null
    public void setText(String text){
        this.text = text;
    }
    public void clear(){
        this.text = ""; //another way is text = ""
    }
}
