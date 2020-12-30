package com.clover;

import java.awt.*;

public interface Resizable {
    //put the same capability in one interface
    void resize(int size);
    void resize(int x, int y);
    void resizeTo(UIWidget widget);
}
