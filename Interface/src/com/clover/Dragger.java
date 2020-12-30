package com.clover;

public class Dragger{
    //it decouple with UIWidget but only use one method if the other two changed will also impact this Class
    void drag(UIWidget uiWidget){
        uiWidget.drag();
    }
}
