package org.example;

import java.util.Arrays;
import java.util.List;

public class GroupingByStreamAPIExample {
    List<Person> people = Arrays.asList(
            new Person("Alice", "New York", 30, "F"),
            new Person("Bob", "London", 25, "M"),
            new Person("Charlie", "New York", 22, "M"),
            new Person("David", "London", 32, "M"),
            new Person("Eve", "Paris", 29, "F"),
            new Person("Fiona", "Paris", 35, "F"),
            new Person("George", "New York", 40, "M")
    );

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

    public String getCity() { return city; }
    public int getAge() { return age; }
    public String getGender() { return gender; }

    public String toString() {
        return name + "(" + age + ", " + gender + ")";
    }
}
