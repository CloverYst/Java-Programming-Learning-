package com.clover;

public class Employee {
    //instance members
    private int baseSalary;
    private int hourlyRate;
    //static members
    public static int numberOfEmployees;
    public Employee(int baseSalary, int hourlyRate){
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }
    public Employee(int baseSalary){
        /*
        setBaseSalary(baseSalary);
        setHourlyRate(0);
        */
        this(baseSalary,0);
    }
    public static void printNumberOfEmployee(){
        System.out.println(numberOfEmployees);
        //cannot access other methods like calculateSalary, so we need to create a Employee instance"new Employee()." to use 
    }
    private void setBaseSalary(int baseSalary){
        if(baseSalary<=0)
            throw new IllegalArgumentException("Salary can not be 0 or less");
        this.baseSalary = baseSalary;
    }
    public int getBaseSalary(){
        return baseSalary;
    }
    /*public void setHourlyRate(int hourlyRate){
        if(hourlyRate<=0)
            throw new IllegalArgumentException("HourlyRate can not be 0 or less");
        this.hourlyRate = hourlyRate;
    }
    public int getHourlyRate(){
        return hourlyRate;
    }*/
    public int calculateWage(int extraHours){
        return baseSalary + ( extraHours * getHourlyRate());
    }
    //overloading method
    public int calculateWage(){
        return calculateWage(0); //overloading twice because we use it inside this method
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    private void setHourlyRate(int hourlyRate) {
        if(hourlyRate<0)
            throw new IllegalArgumentException("hourlyRate can not be 0 or less");
        this.hourlyRate = hourlyRate;
    }
}
