package be.craftmine.kata.rover;


import java.util.ArrayList;
import java.util.List;

public class Grid {
    private static final int MAX_HEIGHT = 10;
    private static final int MAX_WIDTH = 10;
    private final List<Coordinnate> obstacles;

    public Grid() {
        this.obstacles = new ArrayList<>();
    }

    Grid(List<Coordinnate> obstacles) {
        this.obstacles = obstacles;
    }

    Path nextCoordinateFor(Path path, Direction direction) {
        int y = path.currentCoordinnate.y;
        int x = path.currentCoordinnate.x;
        if (direction == Direction.NORTH)
            y = (y + 1) % MAX_HEIGHT;
        if (direction == Direction.EAST)
            x = (x + 1) % MAX_HEIGHT;
        if (direction == Direction.WEST)
            x = (x > 0) ? x - 1 : MAX_WIDTH - 1;
        if (direction == Direction.SOUTH)
            y = (y > 0) ? y - 1 : MAX_HEIGHT - 1;
        Coordinnate newCoordonnate = new Coordinnate(x, y);
        if (obstacles.contains(newCoordonnate))
            path.setCurrentCoordonate(path.currentCoordinnate, true);
        else
            path.setCurrentCoordonate(newCoordonnate, false);
        return path;

    }
}
