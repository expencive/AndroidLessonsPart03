package com.example.javacore.Interfaces;

public class Person implements Info {

    public String name;

    public Person(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Hello");
    }


    @Override
    public void showInfo() {
        System.out.println("My name is: " + name);
    }

    @Override
    public void makeSound() {
        System.out.println("Im a man");
    }
}
