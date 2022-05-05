package com.company.Person;

public class Person {
    public String sname;
    String name;
    int age;

    public Person(String name, String sname, int age){
        this.name = name;
        this.sname = sname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                '}';
    }
}
