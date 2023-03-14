package ru.job4j.search;

import java.util.ArrayList;
import java.util.Arrays;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();


    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for(Person index : persons) {
            if (index.getPhone().contains(key) || index.getName().contains(key) || index.getSurname().contains(key)
            || index.getAddress().contains(key)){
                result.add(index);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Person person = new Person("Petr", "Arsentyev", "8903", "Star street");
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(person);
        System.out.println(phoneDictionary.find("8903").get(0).getName());
    }
}