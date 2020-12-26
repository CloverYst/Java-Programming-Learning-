package com.clover;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var textBox1 = new TextBox(); //var is easy way OR use TextBox textBox1...
        textBox1.setText("Box 1");
        System.out.println(textBox1.text);

        var textBox2 = new TextBox();
        textBox2.setText("Box 2");
        System.out.println(textBox2.text);


        //Memory allocation and deallocation
        var tB1 = new TextBox(); //left is store the object address in stack is a reference right is an object stored in heap
        var tB2 = tB1; // copy the object address
        tB2.setText("Hello tB1");
        System.out.println(tB1.text);

        /*//Procedural Programming (use class doesn't means u are using object-oriented)
        int basicSalary = 5_000;
        int extraHours = 10;
        int hoursPer = 20;
        int wage = calculateWage(basicSalary,extraHours,hoursPer);
        System.out.println(wage);*/


        //Employee Class
        var employee = new Employee(50_000,20);// Employee is a method create automatically created by Java
       /* employee.baseSalary = 50_000;
        employee.hoursRate = 20;*/
        //u have to use in a particular way. make the interface of the class simple

        /*employee.setBaseSalary(50_000);
        //because the field access mode is private how can we access we can create a method
        //employee.getBaseSalary();
        employee.setHourlyRate(10);
       // employee.getHourlyRate();*/

        int wage = employee.calculateWage(10);
        int wage2 = employee.calculateWage();
        System.out.println(wage);
        //access directly through class
        //System.out.println(Employee.numberOfEmployees);
        Employee.printNumberOfEmployee();


        //Browser Class
        var browser = new Browser();

    }
    //when finished the main method, java will automatically clear the references in the stack and the objects unused
    //anymore will called garbage collection.

    /*public static int calculateWage(
            int basicSalary,
            int extraHours,
            int hoursPer
    ){
        return basicSalary + (extraHours * hoursPer);
    }*/
}
