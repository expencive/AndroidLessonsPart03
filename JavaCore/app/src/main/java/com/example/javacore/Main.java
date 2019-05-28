package com.example.javacore;

public class Main {

    int age;
    String name;

    public Main(int integerr, String stringg) {
        age = integerr;
        name = stringg;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println("Print----------------" + age  + name );
    }

    public int yearsto(){
        int years = 100-age;
        return years;
    }

    public String newString(){
        String newString = " Меня зовут: " + name;
        return newString;
    }

    public void newAgeName(int age, String name){
        this.age = age;
        this.name = name;
    }
}
