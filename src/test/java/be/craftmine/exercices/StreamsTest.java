package be.craftmine.exercices;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class StreamsTest {

//    Use a Stream to filter only even numbers from a list of integers
    @Test
    void filter_list_even_numbers() {
        List<Integer> numbers = List.of(1,2,3,4,5);

        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        Assertions.assertThat(evens).isEqualTo(List.of(2,4));
    }

    //    Sort a list of strings alphabetically
    @Test
    void sort_list_alphabetically() {
        List<String> names = List.of("a", "c", "b");

        List<String> sorted = names.stream()
                .sorted()
                .toList();

        Assertions.assertThat(sorted).isEqualTo(List.of("a", "b", "c"));
    }

    //   Find the sum of all numbers in a list using reduce
    @Test
    void sum_list() {
        List<Integer> numbers = List.of(1, 2, 3);

        Optional<Integer> reduce = numbers.stream()
                .reduce(Integer::sum);

        Assertions.assertThat(reduce.get()).isEqualTo(6);
    }

    //   Use a Stream to find the largest and smallest number in a list.
    @Test
    void find_largest_smallest() {
        List<Integer> numbers = List.of(1, 2, 3,4,5);

        int min = numbers.stream().min(Integer::compare).orElseThrow();
        int max = numbers.stream().max(Integer::compare).orElseThrow();

        Assertions.assertThat(min).isEqualTo(1);
        Assertions.assertThat(max).isEqualTo(5);
    }
}
