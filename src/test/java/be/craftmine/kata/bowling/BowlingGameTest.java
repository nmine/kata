package be.craftmine.kata.bowling;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    private BowlingGame game;

    @Test
    void can_score_gutter_game() {
        game = new BowlingGame();
        roll(20, 0);
        Assertions.assertThat(game.getScore()).isEqualTo(0);
    }

    @Test
    void can_score_game_of_one() {
        game = new BowlingGame();
        roll(20, 1);
        Assertions.assertThat(game.getScore()).isEqualTo(20);
    }

    @Test
    void can_score_spare_followed_by_one() {
        game = new BowlingGame();
        game.roll(5);
        game.roll(5);
        game.roll(3);
        roll(17, 0);
        Assertions.assertThat(game.getScore()).isEqualTo(16);
    }

    @Test
    void can_score_strike() {
        game = new BowlingGame();
        game.roll(10);
        game.roll(3);
        game.roll(3);
        roll(17, 0);
        Assertions.assertThat(game.getScore()).isEqualTo(22);
    }

    @Test
    void can_score_perfect_game() {
        game = new BowlingGame();
        roll(12, 10);
        Assertions.assertThat(game.getScore()).isEqualTo(300);
    }

    private void roll(int times, int pinDown) {
        for (int i = 0; i < times; i++) {
            game.roll(pinDown);
        }
    }


}
