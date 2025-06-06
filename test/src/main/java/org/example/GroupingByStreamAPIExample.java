package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingByStreamAPIExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", "New York", 30, "F", Arrays.asList("Reading", "Cooking")),
                new Person("Bob", "London", 25, "M", Arrays.asList("Football", "Cooking")),
                new Person("Charlie", "New York", 22, "M", Arrays.asList("Gaming", "Reading")),
                new Person("David", "London", 32, "M", Arrays.asList("Traveling", "Football")),
                new Person("Eve", "Paris", 29, "F", Arrays.asList("Dancing", "Cooking")),
                new Person("Fiona", "Paris", 35, "F", Arrays.asList("Reading", "Yoga")),
                new Person("George", "New York", 40, "M", Arrays.asList("Cooking", "Chess"))
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

        // Find any person from London
        System.out.println(people.stream().filter(p->"London".equals(p.getCity())).findAny().get());

        //Group people by city, then gender
        System.out.println(people.stream().collect(Collectors.groupingBy(Person::getCity)));
        //returns Map( String-City Name, List of Persion)
        System.out.println(people.stream().collect(Collectors.groupingBy(Person::getCity,
                Collectors.groupingBy(Person::getGender))));
        // returns Map(String-city name,Map( String-City Name, List of Persion)

        //List all unique hobbies
        System.out.println(people.stream().flatMap(p->p.getHobbies().stream()).collect(Collectors.toSet()));

        //Count how many people have each hobby
        System.out.println(people.stream().flatMap(p->p.getHobbies().stream()).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        // Example: Group people by hobby

    }
}


class Person {
    String name;
    String city;
    int age;
    String gender;
    private List<String> hobbies;

    Person(String name, String city, int age, String gender, List<String> hobbies) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;
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

    public List<String> getHobbies() { return hobbies; }
    public String toString() {
        return name + "(" + age + ", " + gender + ")";
    }
}
