package be.craftmine.exercices.moderne_java_in_action.chap5;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.*;

public class Chap5 {

    //flatMap
//    Given two lists of numbers, how would you return all pairs of numbers?
//    For example, given a list [1, 2, 3] and a list [3, 4] you should return
//    [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].
//    For simplicity, you can represent a pair as an array with two elements.

    @Test
    void combine_arrays() {
        List<String> words = List.of("apple", "an", "banana", "apricot", "cat");

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> list = numbers1.stream().flatMap(n ->
                numbers2.stream().map(n2 -> new int[]{n, n2})
        ).filter(ints -> (ints[0] + ints[1]) % 3 == 0).toList();

        out.println(words.stream()
                .filter(s -> s.startsWith("a"))
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList()));
    }

    @Test
    void sum() {
        List<Integer> numbers = List.of(1, 2, 3);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
    }

    List<Transaction> initTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

    }

    //Finds all transactions in 2011 and sort by value (small to high)
    @Test
    void find_transaction() {
        List<Transaction> transactions = initTransactions();

        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();

        out.println(list);

    }

    //What are all the unique cities where the traders work?
    @Test
    void unique_cities() {
        List<Transaction> transactions = initTransactions();

        List<String> list = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .toList();

        out.println(list);
    }

    //Finds all traders from Cambridge and sort them by name
    @Test
    void trader_from_cambridge() {
        List<Transaction> transactions = initTransactions();

        List<Trader> list = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Milan".equals(t.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .toList();

        out.println(list);
    }

    // Returns a string of all traders’ names sorted alphabetically
    @Test
    void trader_sorted_alpha() {
        List<Transaction> transactions = initTransactions();

        String list = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
//                .collect(Collectors.joining());
                .reduce((s, s2) -> s + s2).orElseThrow();

        out.println(list);
    }

    // Are any traders based in Milan?
    @Test
    void trader_based_milan() {
        List<Transaction> transactions = initTransactions();

        boolean anyMatch = transactions.stream()
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));

        out.println(anyMatch);
    }

    //  Prints all transactions’ values from the traders living in Cambridge
    @Test
    void print_value_from_milan() {
        List<Transaction> transactions = initTransactions();

        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
                .map(Transaction::getValue)
                .forEach(out::println);

    }

    //  What’s the highest value of all the transactions?
    @Test
    void highest_value() {
        List<Transaction> transactions = initTransactions();

        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

    }

    //  What’s the highest value of all the transactions?
    @Test
    void pytagore() {
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                        );

    }

    //  What’s the highest value of all the transactions?
    @Test
    void fibonacci() {
        Stream.iterate(new int[]{0, 1},
                        t -> new int[]{t[1],t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);

        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

    }

    //    Générez une plage de nombres entiers de 1 à 100. Filtrez uniquement les nombres pairs
    //    et calculez la somme des carrés de ces nombres.
    @Test
    void sum_square() {
        double sum = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .mapToDouble(Math::sqrt)
                .sum();

        out.println(sum);
    }

    //    Créez toutes les paires possibles de nombres (a, b) où a est dans la plage [1, 10] et b est dans la plage [1, 5].
    //    Affichez chaque paire sous la forme (a, b).
    @Test
    void create_pair() {
        Stream<Object> objectStream = IntStream.rangeClosed(1, 5).mapToObj(b -> new int[]{0, b});
        Stream<Object> objectStream1 = IntStream.rangeClosed(1, 10).boxed().flatMap(a -> objectStream);

//        out.println(sum);
    }

    @Test
    void reduce_test() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers = stream.reduce(
                new ArrayList<>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l; },
                (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1; });
    }
}
