package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GroupingByStreamAPIExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", "New York", 30, "F"),
                new Person("Bob", "London", 25, "M"),
                new Person("Charlie", "New York", 22, "M"),
                new Person("David", "London", 32, "M"),
                new Person("Eve", "Paris", 29, "F"),
                new Person("Fiona", "Paris", 35, "F"),
                new Person("George", "New York", 40, "M")
        );

        // Find all people from "New York"
        System.out.println(people.stream().filter(p -> "New York".equals(p.getCity())).toList());

        // Get the names of all females
        System.out.println(people.stream().filter(p -> "F".equals(p.getGender()))
                .map(Person::getName).collect(Collectors.toList()));

        ///Group people by city
        System.out.println(people.stream().collect(Collectors.groupingBy(Person::getCity)));

        //Count the number of people in each city
        System.out.println(people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.counting())));

        //Find the oldest person
        System.out.println(people.stream().max(Comparator.comparingInt(Person::getAge)).get());

        //Partition people into male and female
        System.out.println(people.stream().collect(Collectors.partitioningBy(p -> "M".equals(p.getGender()))));

        //List of names sorted by age
        System.out.println(people.stream().sorted(Comparator.comparingInt(Person::getAge)).map(Person::getName).toList());

        //  Total age of people in Paris
        System.out.println(people.stream().filter(p -> "Paris".equals(p.getCity())).mapToInt(Person::getAge).sum());

        //Check if all people are older than 20
        System.out.println(people.stream().allMatch(p -> p.getAge() > 20));
    }
}


class Person {
    String name;
    String city;
    int age;
    String gender;

    Person(String name, String city, int age, String gender) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String toString() {
        return name + "(" + age + ", " + gender + ")";
    }
}
