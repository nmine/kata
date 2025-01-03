package be.craftmine.exercices.moderne_java_in_action.chap6;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class Chap6 {

    // Counting
    @Test
    void name() {
        List<String> strings = List.of("apple", "banana", "car", "door", "elephant");

        Long collect = strings.stream()
                .filter(s -> s.length() > 4)
                .count();

        System.out.println(collect);
    }

    // Counting
    @Test
    void SummingInt() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);


        int collect = numbers.stream()
                .filter(n -> n % 2 == 0).mapToInt(n -> n).sum();

        System.out.println(collect);
    }

    // joining
    @Test
    void joining() {
        List<String> words = List.of("Java", "is", "fun");



        String collect = words.stream()
                .collect(Collectors.joining(" "));

        System.out.println(collect);
    }

    // reducing
    @Test
    void reducing() {
        List<Integer> numbers = List.of(1, 2, 3, 4);

        Integer collect = numbers.stream()
                .collect(Collectors.reducing(1, (n,n2) -> n*n2));

        System.out.println(collect);
    }

    // collecting and then
    @Test
    void CollectingAndThen() {
        List<String> strings = List.of("apple", "banana", "car");

        List<String> collect = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

        System.out.println(collect);
    }

    @Test
    void GroupingBy() {
        List<String> strings = List.of("apple", "banana", "car", "abricot");

        Map<Character, List<String>> map = strings.stream()
                .collect(Collectors.groupingBy(s -> s.toCharArray()[0]));

        System.out.println(map);
    }

    @Test
    void PartitioningBy() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> map = numbers.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        System.out.println(map);
    }

    @Test
    void collect() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Object> collect = numbers.stream().collect(ArrayList::new,
                List::add,
                List::addAll);

        System.out.println(collect);
    }

    public class PrimeNumbersCollector
            implements Collector<Integer,
                        Map<Boolean, List<Integer>>,
                        Map<Boolean, List<Integer>>> {
        @Override
        public Supplier<Map<Boolean, List<Integer>>> supplier() {
            return () -> new HashMap<Boolean, List<Integer>>() {{
                put(true, new ArrayList<Integer>());
                put(false, new ArrayList<Integer>());
            }};
        }
        @Override
        public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
            return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
                acc.get( isPrime( acc.get(true),
                                candidate) )
                        .add(candidate);
            };
        }

        private Boolean isPrime(List<Integer> integers, Integer candidate) {
            return null;
        }

        @Override
        public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
            return (Map<Boolean, List<Integer>> map1,
                    Map<Boolean, List<Integer>> map2) -> {
                map1.get(true).addAll(map2.get(true));
                map1.get(false).addAll(map2.get(false));
                return map1;
            };
        }
        @Override
        public Function<Map<Boolean, List<Integer>>,
                        Map<Boolean, List<Integer>>> finisher() {
            return Function.identity();
        }
        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
        }
    }
}
