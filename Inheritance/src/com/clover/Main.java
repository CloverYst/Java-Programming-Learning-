package com.clover;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var textBox = new TextBox();
        textBox.disable();
        System.out.println(textBox.isEnabled());

        //all the classes we created directly or indirectly inherit from Object Class
        var box1 = new TextBox();
        var box2 = box1;
        System.out.println(box1.equals(box2));
        System.out.println(box1.hashCode());
        System.out.println(box1.toString());

        box1.setText("Hello Box1");
        System.out.println(box1);//box1.toString() is unnecessary because use the println is a method override it will use toString

        //Upcasting and Downcasting
        //var control = new UIControl();
        var textBox1 = new TextBox();
        //show(control);
        show(textBox1);

        //Compare Objects overrid
        var point1 = new Point(1,2);
        var point2 = new Point(1,2);
        System.out.println(point1.equals(point2));
        System.out.println(point1.hashCode());
        System.out.println(point2.hashCode());

        //Polymorphism
        UIControl[] controls = {new TextBox(),new CheckBox()};
        for (UIControl ctrl: controls){
            //A procedural way are many ifs each time add new type we need to add a if clause
            //if control is TextBox
            //  render TextBix
            //if control is CheckBox
            //  render CheckBox

            ctrl.render();
        }
    }

    public static void show(UIControl control){
        if(control instanceof TextBox) {
            var textBox = (TextBox) control;
            textBox.setText("Happy TextBox");
        }
        System.out.println(control);
    }
}
