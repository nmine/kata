package be.craftmine.kata.rover;

import java.util.Objects;

public class Coordinnate {
    public final int y;
    public final int x;

    public Coordinnate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinnate that = (Coordinnate) o;
        return y == that.y && x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}
