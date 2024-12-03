package ru.ugrasu.lab5;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    record Person(String name, int age, String sex, String color) {
    }


    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Иван", 30, "M", "White"),
                new Person("Вика", 31, "W", "Black"),
                new Person("Иван", 32, "M", "White"),
                new Person("Настя", 33, "W", "Yellow")
        );

        List<Person> filteredPeople = filter(people, ((Predicate<Person>) (person -> person.age() > 31))
                .and((person -> "W".equals(person.sex()))));

        filteredPeople.forEach(person ->
                System.out.println(person.name() + ", " + person.age() + ", " + person.sex() + ", " + person.color())
        );
    }

    private static List<Person> filter(List<Person> people, Predicate<Person> personPredicate) {
        return people.stream()
                .filter(personPredicate)
                .toList();
    }
}


