package org.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Producer producer = new Producer();


        for(int i=0;i<100; i++) {
            Student student = new Student(i, "hamza");
            producer.produce(student.getId()+"", student.toString());
        }

        System. exit(0);
    }
}