package ru.job4j.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();


    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = person -> person.getName().equals(key);
        Predicate<Person> predicateSurname = person -> person.getSurname().equals(key);
        Predicate<Person> predicatePhone = person -> person.getPhone().equals(key);
        Predicate<Person> predicateAddress = person -> person.getAddress().equals(key);
        Predicate<Person> combine = predicateName.or(predicateSurname).or(predicatePhone).or(predicateAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var person = new Person("Petr", "Arsentyev", "8903", "Star street");
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(person);
        System.out.println(phoneDictionary.find("8903").get(0).getName());
    }
}