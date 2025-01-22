package be.craftmine.kata.rover;

import java.util.Arrays;

enum Direction {
    NORTH("N", "W", "E"),
    EAST("E", "N", "S"),
    SOUTH("S", "E", "W"),
    WEST("W", "S", "N");

    public String value;
    public String left;
    public String right;

    Direction(String value, String left, String right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    Direction moveRight() {
        return this.fromValue(this.right);
    }

    Direction moveLeft() {
        return this.fromValue(this.left);
    }

    Direction fromValue(String direction) {
        return Arrays.stream(Direction.values())
                .filter(d -> d.value.equals(direction))
                .findFirst()
                .orElseThrow();
    }
}