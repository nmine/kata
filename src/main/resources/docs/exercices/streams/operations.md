# Opérations sur les Streams en Java

En Java, les opérations sur les **Streams** (API introduite dans Java 8) se divisent principalement en deux catégories : **opérations intermédiaires** et **opérations terminales**.

---

## **1. Opérations intermédiaires**

Les opérations intermédiaires transforment un Stream en un autre Stream. Elles sont **paresseuses**, c’est-à-dire qu’elles ne s'exécutent pas tant qu'une opération terminale n'est pas appelée. Ces opérations sont chaînables.

### Principales opérations intermédiaires :

- **`filter(Predicate<T>)`**  
  Permet de filtrer les éléments selon un prédicat donné.
  ```java
  List<Integer> numbers = List.of(1, 2, 3, 4, 5);
  numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

flatMap(Function<T, Stream<R>>)
Aplatie des structures de données imbriquées en un seul Stream.

java
Copier le code
List<List<Integer>> lists = List.of(List.of(1, 2), List.of(3, 4));
lists.stream().flatMap(List::stream).forEach(System.out::println);