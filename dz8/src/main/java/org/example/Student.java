package org.example;

public class Student {

    private final int id;
    private final String firstName;
    private final String lastName;

    public Student(int id, String name, String surname) {
            this.id = id;
            this.firstName = name;
            this.lastName = surname;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

}



