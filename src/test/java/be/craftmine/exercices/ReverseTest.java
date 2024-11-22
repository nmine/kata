package be.craftmine.exercices;

import be.craftmine.kata.Kata;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseTest {
    @Test
    void one_letter_should_return_this_letter() {
        assertEquals("a", Kata.reverseWords("a"));
    }

    @Test
    void empty_word_should_return_empty() {
        assertEquals("", Kata.reverseWords(""));
    }

    @Test
    void two_letters_word_should_return_reverse_letter() {
        assertThat(Kata.reverseWords("ab")).isEqualTo("ba");
    }

    @Test
    void three_letters_word_should_return_reverse_letters() {
        assertThat(Kata.reverseWords("abc")).isEqualTo("cba");
    }

//   @Test
//     void exampleCases() {
//         assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", Kata.reverseWords("The quick brown fox jumps over the lazy dog."), "Input: \"The quick brown fox jumps over the lazy dog.\"");
//         assertEquals("elppa", Kata.reverseWords("apple"), "Input: \"apple\"");
//         assertEquals("a b c d", Kata.reverseWords("a b c d"), "Input: \"a b c d\"");
//         assertEquals("  elbuod  decaps  sdrow  ", Kata.reverseWords("  double  spaced  words  "), "Input: \"  double  spaced  words  \"");
//     }
}