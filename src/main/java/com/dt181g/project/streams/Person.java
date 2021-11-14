package com.dt181g.project.streams;

public class Person {
    private String name;
    private int age;
    private int netWorth;
    private boolean isMarried;

    public Person(String name, int age, int netWorth, boolean isMarried) {
        this.name = name;
        this.age = age;
        this.netWorth = netWorth;
        this.isMarried = isMarried;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNetWorth() {
        return netWorth;
    }

    public boolean isMarried() {
        return isMarried;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nNet Worth: " + netWorth + "\nMarital status: " + isMarried + "\n";

    }
}
