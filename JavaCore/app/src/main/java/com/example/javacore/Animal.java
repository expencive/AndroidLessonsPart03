package com.example.javacore;

public abstract class Animal {
     String type;
    protected int legs;

    public Animal(String type, int legs) {
        this.type = type;
        this.legs = legs;
    }

    public void makeSound(){
        System.out.println("zzzzzzzzzzzzz");

    }

    public void move(){
        System.out.println("Moving");

    }
    public abstract void breath();

    @Override
    public boolean equals(Object obj) {
        Animal animal = (Animal) obj;

        if (this.type.equals(animal.type) && this.legs==animal.legs){
            return true;
        }else {
          return false;
        }

    }
}
