package be.craftmine.kata.bowling;

public class BowlingGame {

    private int roll = 0;
    private int[] rolls = new int[21];

    public void roll(int pin) {
        rolls[roll++] = pin;
    }

    public Integer getScore() {
        int score = 0;
        int cursor = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(cursor)) {
                score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
                cursor++;
            } else if (isSpare(cursor)) {
                score += 10 + rolls[cursor + 2];
                cursor += 2;
            } else {
                score += rolls[cursor] + rolls[cursor + 1];
                cursor += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int cursor) {
        return rolls[cursor] == 10;
    }

    private boolean isSpare(int cursor) {
        return rolls[cursor] + rolls[cursor + 1] == 10;
    }

}
