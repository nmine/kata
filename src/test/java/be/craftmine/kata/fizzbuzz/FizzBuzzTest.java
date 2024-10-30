package be.craftmine.kata.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    public void testDivisibleBy3() {
        assertEquals("Fizz", FizzBuzz.getResult(3));
        assertEquals("Fizz", FizzBuzz.getResult(6));
    }

    @Test
    public void testDivisibleBy5() {
        assertEquals("Buzz", FizzBuzz.getResult(5));
        assertEquals("Buzz", FizzBuzz.getResult(10));
    }

    @Test
    public void testDivisibleBy3And5() {
        assertEquals("FizzBuzz", FizzBuzz.getResult(15));
        assertEquals("FizzBuzz", FizzBuzz.getResult(30));
    }

    @Test
    public void testNotDivisibleBy3Or5() {
        assertEquals("1", FizzBuzz.getResult(1));
        assertEquals("2", FizzBuzz.getResult(2));
    }
}
