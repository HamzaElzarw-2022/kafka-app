package org.example;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "student id= " + id + ",  name= " + name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
