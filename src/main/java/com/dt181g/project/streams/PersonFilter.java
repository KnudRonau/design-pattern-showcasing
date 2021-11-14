package com.dt181g.project.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Entity providing various data access methods using Stream.
 * @author Knud Ronau Larsen
 */
public class PersonFilter {
    private final List<Person> persons = new ArrayList<>();

    /**
     * Creates and stores 10 people in the persons list.
     */
    public PersonFilter() {
        persons.add(new Person("Bob", 22, 25000, false));
        persons.add(new Person("Sandra", 54, 400000, true));
        persons.add(new Person("Karen", 12, 250, false));
        persons.add(new Person("Kristian", 38, 650000, false));
        persons.add(new Person("Lasse", 98, 2000000, true));
        persons.add(new Person("Per", 76, 95800000, true));
        persons.add(new Person("Niels", 54, 2360, false));
        persons.add(new Person("Kristina", 65, 7500000, true));
        persons.add(new Person("Sarah", 46, 18000000, true));
        persons.add(new Person("Signe", 29, 150000, false));
    }

    /**
     * Method to return all info about all people in a formatted String
     * @return String containing all info about people
     */
    public String getPeople() {
        return allToString(persons);
    }

    /**
     * Method to return names of all people who have a net worth higher than a million
     * @return names of millionaires
     */
    public String getMillionaires() {
        List<Person> millionaires = persons.stream().filter(person -> person.getNetWorth() > 1000000).collect(Collectors.toList());
        return namesToString(millionaires);
    }

    /**
     * Method to sort all the names alphabetically
     * @return alphabetically sorted String
     */
    public String getSortedNames() {
        List<Person> namesSorted = persons.stream().sorted(Comparator.comparing(person -> person.getName()))
                .collect(Collectors.toList());
        return namesToString(namesSorted);
    }

    /**
     * Method to return the oldest person
     * @return name of oldest person
     */
    public String getOldest() {
        Person oldest = persons.stream().max(Comparator.comparing(person -> person.getAge()))
                .orElseThrow(NoSuchElementException::new);
        return oldest.getName();
    }

    /**
     * Method to return all married people
     * @return String containing names of all married people.
     */
    public String getMarried() {
        List<Person> marriedPeople = persons.stream().filter(person -> person.isMarried()).collect(Collectors.toList());
        return namesToString(marriedPeople);
    }

    /**
     * Private method used internally to format a Person List to a String containing their names
     * @param personList Provided list of persons
     * @return String of names each on new lines
     */
    private String namesToString(List<Person> personList) {
        StringBuilder info = new StringBuilder();
        for(Person person : personList) {
            info.append(person.getName()).append("\n");
        }
        return info.toString();
    }

    /**
     * Private method used internally to format a Person List to a String containing all their info
     * @param personList Provided list of persons
     * @return Formatted String containing all info on people.
     */
    private String allToString(List<Person> personList) {
        StringBuilder info = new StringBuilder();
        for(Person person : personList) {
            info.append(person.toString()).append("\n");
        }
        return info.toString();
    }
}
