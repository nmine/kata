package be.craftmine.exercices.moderne_java_in_action.chap8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chap8 {

    // Écrivez une boucle forEach pour afficher chaque ami et son âge au format suivant
    // Alice is 30 years old
    @Test
    void for_each() {
        Map<String, Integer> ageOfFriends = Map.of(
                "Alice", 30,
                "Bob", 25,
                "Charlie", 35
        );

        ageOfFriends.
                forEach((name, age) -> System.out.println(name+" is "+age));
    }

    // Ajoutez une recherche pour un ami nommé "David". S'il n'est pas trouvé, retournez l'âge par défaut de 20 ans.
    @Test
    void getOrDefault() {
        Map<String, Integer> ageOfFriends = Map.of(
                "Alice", 30,
                "Bob", 25,
                "Charlie", 35
        );

        Integer david = ageOfFriends.getOrDefault("David", 28);
        System.out.println(david);
    }

    @Test
    void computeIfAbsent() {
        Map<String, List<String>> friendsToMovies = new HashMap<>();

        friendsToMovies.computeIfAbsent("Alice", s -> new ArrayList<>()).add("Inception");

        friendsToMovies.computeIfPresent("Alice", (name, movies) -> {
            movies.add("Inception");
            return movies;
        });

    }

    // Créez une Map<String, String> contenant les noms des amis comme clés et leurs plats préférés comme valeurs :
    @Test
    void remove() {
        Map<String, String> favoriteDishes = new HashMap<>();
        favoriteDishes.put("Alice", "Pizza");
        favoriteDishes.put("Bob", "Pasta");

        favoriteDishes.remove("Alice", "Pizza");

        System.out.println(favoriteDishes);
    }

    @Test
    void replaceAll() {
        Map<String, String> favoriteDishes = new HashMap<>();
        favoriteDishes.put("Alice", "Pizza");
        favoriteDishes.put("Bob", "Pasta");

        favoriteDishes.replaceAll( (name,dishe) -> dishe.toUpperCase());

        System.out.println(favoriteDishes);
    }

    @Test
    void merge() {
        Map<String, String> familyFavorites = Map.of("Alice", "Titanic", "Charlie", "Avatar");
        Map<String, String> friendsFavorites = Map.of("Alice", "Inception", "Bob", "Matrix");

        HashMap<String, String>  everyOneFavorites = new HashMap<>(familyFavorites);
        friendsFavorites.forEach((name,movie) ->
                everyOneFavorites.merge(name,movie, (v1,v2) ->v1+"&"+v2 ));

        System.out.println(everyOneFavorites);
    }
}
