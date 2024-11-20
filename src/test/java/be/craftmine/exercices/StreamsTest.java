package be.craftmine.exercices;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StreamsTest {

    //    Use a Stream to filter only even numbers from a list of integers
    @Test
    void filter_list_even_numbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> evens = null;

        Assertions.assertThat(evens).isEqualTo(List.of(2, 4));
    }

    //    Sort a list of strings alphabetically
    @Test
    void sort_list_alphabetically() {
        List<String> names = List.of("a", "c", "b");

        List<String> sorted = null;

        Assertions.assertThat(sorted).isEqualTo(List.of("a", "b", "c"));
    }

    //   Find the sum of all numbers in a list using reduce
    @Test
    void sum_list() {
        List<Integer> numbers = List.of(1, 2, 3);

        Optional<Integer> reduce = null;

        Assertions.assertThat(reduce.get()).isEqualTo(6);
    }

    //   Use a Stream to find the largest and smallest number in a list.
    @Test
    void find_largest_smallest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int min = 0;
        int max = 0;

        Assertions.assertThat(min).isEqualTo(1);
        Assertions.assertThat(max).isEqualTo(5);
    }

    //   Combine two lists of strings into one without using explicit loops.
    @Test
    void combine_list() {
        List<String> list1 = List.of("A", "B", "C");
        List<String> list2 = List.of("D", "E", "F");

        List<String> merged = null;

        Assertions.assertThat(merged).isEqualTo(List.of("A", "B", "C", "D", "E", "F"));
    }

    //   Group a list of Person objects by age.

    @Data
    @AllArgsConstructor
    class Person {
        String name;
        int age;
    }

    @Test
    void group_by_age() {
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30)
        );

        Map<Integer, List<Person>> groupedByAge = null;
        System.out.println(groupedByAge);
    }

    //  Combine a list of words into a single string separated by commas
    @Test
    void combine_by_comma() {
        List<String> words = List.of("apple", "banana", "cherry");

        String result = null;
        System.out.println(result); // Output: apple, banana, cherry
    }

    //  Write a function to detect duplicates in a list of integers.
    @Test
    void find_duplicate() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 2, 5, 3);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = null;
        System.out.println(duplicates);
    }
}
