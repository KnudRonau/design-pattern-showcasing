package com.dt181g.project.streams;

/**
 * Entity resembling a person. Carries various attributes for showcasing Stream usage
 * @author Knud Ronau Larsen
 */
public class Person {
    private String name;
    private int age;
    private int netWorth;
    private boolean isMarried;

    /**
     * Constructor storing provided values to attributes.
     * @param name person's name
     * @param age person's age
     * @param netWorth person's net worth
     * @param isMarried person's marital status
     */
    public Person(String name, int age, int netWorth, boolean isMarried) {
        this.name = name;
        this.age = age;
        this.netWorth = netWorth;
        this.isMarried = isMarried;
    }

    /**
     * Returns name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns net worth
     * @return net worth
     */
    public int getNetWorth() {
        return netWorth;
    }

    /**
     * Returns marital status
     * @return boolean value representing marital stats
     */
    public boolean isMarried() {
        return isMarried;
    }

    /**
     * Returns all the info in a formatted String
     * @return String with personal info
     */
    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nNet Worth: " + netWorth + "\nMarital status: " + isMarried + "\n";

    }
}
