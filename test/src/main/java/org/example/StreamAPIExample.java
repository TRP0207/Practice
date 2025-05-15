package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIExample {
    public static void main(String[] args) {
        /*List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Find all even numbers from a list of integers
//        numbers.stream().filter(x -> x % 2 == 0).forEach((n) -> System.out.print(n + " "));


        //Convert a list of strings into a list of their lengths
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
//        words.stream().map(string -> string.length()).forEach(System.out::println);

        //Remove duplicates from a list of integers
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6);
//        numbersWithDuplicates.stream().distinct().forEach(System.out::println);

        //Find the first non-repeated character in a string
        String inputString = "swiss";

        //Sort a list of strings by their length
        List<String> strings = Arrays.asList("elephant", "dog", "cat", "hippopotamus");
//        strings.stream().sorted((a, b) -> Integer.compare(a.length(), b.length())).forEach(System.out::println);
//        strings.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);


        //Count how many times each word appears in a given array of strings
        String[] wordArray = {"apple", "banana", "apple", "orange", "banana", "apple"};
        Map<Object, Long> map = Arrays.stream(wordArray).collect(Collectors.groupingBy(string -> string, Collectors.counting()));
//        System.out.println(map);

        //Group employees by department
        class Employee {
            String name;
            String department;

            Employee(String name, String department) {
                this.name = name;
                this.department = department;
            }
        }
        List<Employee> employees = Arrays.asList(
                new Employee("John", "HR"),
                new Employee("Jane", "IT"),
                new Employee("Jack", "HR"),
                new Employee("Jill", "Finance")
        );*/


        String[] wordArray = {"1", "4", "6", "3", "7", "9"};
        IntStream intStream1 = Arrays.stream(wordArray).mapToInt(Integer::valueOf);
        intStream1.forEach(System.out::println);

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        IntStream intStream = listOfLists.stream()
                .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue));

        intStream.forEach(System.out::println);

        /*Stream<String> strings = Stream.of("1,2,3", "4,5");
        IntStream intStream = strings.flatMapToInt(s -> Arrays.stream(s.split(","))
                .mapToInt(Integer::parseInt));

        intStream.forEach(System.out::println);*/
    }
}
