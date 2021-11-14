package com.dt181g.project.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class PersonFilter {
    private List<Person> persons = new ArrayList<>();

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

//    public List<Person> getMillionaires() {
//        return persons.stream().filter(person -> person.getNetWorth() > 1000000).collect(Collectors.toList());
//
//    }

    public String getPeople() {
        return allToString(persons);
    }

    public String getMillionaires() {
        List<Person> millionaires = persons.stream().filter(person -> person.getNetWorth() > 1000000).collect(Collectors.toList());
//        System.out.println(transformToString(millionaires));
        return namesToString(millionaires);
    }

    public String getSortedNames() {
        List<Person> namesSorted = persons.stream().sorted(Comparator.comparing(person -> person.getName()))
                .collect(Collectors.toList());
        return namesToString(namesSorted);
    }

    public String getOldest() {
        Person oldest = persons.stream().max(Comparator.comparing(person -> person.getAge()))
                .orElseThrow(NoSuchElementException::new);
        return oldest.getName();
    }

    public String getMarried() {
        List<Person> marriedPeople = persons.stream().filter(person -> person.isMarried()).collect(Collectors.toList());
        return namesToString(marriedPeople);
    }

    private String namesToString(List<Person> personList) {
        String info = new String();
        for(Person person : personList) {
            info = info + person.getName() + "\n";
        }
        return info;
    }

    private String allToString(List<Person> personList) {
        String info = new String();
        for(Person person : personList) {
            info = info + person.toString() + "\n";
        }
        return info;
    }
}
