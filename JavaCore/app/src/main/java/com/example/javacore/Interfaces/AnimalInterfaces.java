package com.example.javacore.Interfaces;

public class AnimalInterfaces implements Info {

    public int id;

    public AnimalInterfaces(int id) {
        this.id = id;
    }

    public void sleep(){
        System.out.println("Sleep");

    }

    @Override
    public void showInfo() {
        System.out.println("My Id is: " + id);
    }

    @Override
    public void makeSound() {
        System.out.println("Muuuuuuuuuuuuuu");
    }
}
