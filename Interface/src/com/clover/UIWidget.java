package com.clover;

//Interface segregation principle  in order to reduce
public interface UIWidget extends Draggable, Resizable {
    //void drag();
    //void resize();
    void render();
}
