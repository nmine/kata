package be.craftmine.kata.roman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {

    private final RomanNumerals converter = new RomanNumerals();

    @Test
    public void testSingleDigits() {
        assertEquals("I", converter.toRoman(1));
        assertEquals("V", converter.toRoman(5));
        assertEquals("X", converter.toRoman(10));
        assertEquals("L", converter.toRoman(50));
        assertEquals("C", converter.toRoman(100));
        assertEquals("D", converter.toRoman(500));
        assertEquals("M", converter.toRoman(1000));
    }

    @Test
    public void testSubtractiveNotation() {
        assertEquals("IV", converter.toRoman(4));
        assertEquals("IX", converter.toRoman(9));
        assertEquals("XL", converter.toRoman(40));
        assertEquals("XC", converter.toRoman(90));
        assertEquals("CD", converter.toRoman(400));
        assertEquals("CM", converter.toRoman(900));
    }

    @Test
    public void testComplexNumbers() {
        assertEquals("LVIII", converter.toRoman(58));
        assertEquals("MCMXCIV", converter.toRoman(1994));
        assertEquals("MMMCMXCIX", converter.toRoman(3999));
    }

    @Test
    public void testEdgeCases() {
        assertEquals("I", converter.toRoman(1));
        assertEquals("MMM", converter.toRoman(3000));
    }
}