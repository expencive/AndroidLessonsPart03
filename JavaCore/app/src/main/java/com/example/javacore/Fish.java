package com.example.javacore;

public class Fish extends Animal {
    private String color;

    public Fish(String type, int legs, String color) {
        super(type, legs);
        this.color = color;
    }


    @Override
    public void makeSound() {
        System.out.println("booooool - boooool");
    }

    @Override
    public void move() {
        System.out.println("swim____________" + color);
    }

    @Override
    public void breath() {
        System.out.println("Jaber---------");
    }

    public void showType(){
        System.out.println(type);

    }
}
