package com.example.javacore;

public class Dog extends Animal {

    public Dog(String type, int legs) {
        super(type, legs);
    }

    @Override
    public void makeSound() {
        System.out.println("Gav-gav-gav");
    }

    @Override
    public void move() {
        System.out.println("run___________________");
    }

    @Override
    public void breath() {
        System.out.println("Lung");
    }

    public void bark(){
        System.out.println("bark bark bark");
    }
}
