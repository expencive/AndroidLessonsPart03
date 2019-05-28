package com.example.javacore;

public class Static {

    private  int age;
    private String name;

    public static String family = "Ivanov";
    public static int countObjects;

    public Static(int age, String name) {
        this.age = age;
        this.name = name;
        countObjects++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getFamily() {
        return family;
    }

    public static void setFamily(String family) {
        Static.family = family;
    }

    public void printCard(){
        System.out.println("----------" + name + " " + family + " " + age);
    }

    public static void printCounter(){
        System.out.println(countObjects);
    }


    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(name).append(" ").append(family)
                .append(" ").append(age);
        return sb.toString();



    }
}
