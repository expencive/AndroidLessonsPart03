package com.example.javacore;

public class Bug extends Animal {
    public Bug(String type, int legs) {
        super(type, legs);
    }

    public void fly(){
        System.out.println("I'm a bug, i can fly");

    }

    @Override
    public void move() {
        System.out.println("gradle");
    }

    @Override
    public void breath() {
        System.out.println("skin");
    }

    @Override
    public void makeSound() {
        System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
    }
}
