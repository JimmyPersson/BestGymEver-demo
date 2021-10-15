package com.company;

public class Person {
    private String name, social, date;

    public String getName() {
        return name;
    }

    public String getSocial() {
        return social;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", social='" + social + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Person(String name, String social, String date) {
        this.name = name;
        this.social = social;
        this.date = date;
    }
}
