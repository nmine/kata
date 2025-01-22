package be.craftmine.kata.rover;

import lombok.Getter;

@Getter
public class Rover {

    private static final int MAX_HEIGHT = 10;
    private static final int MAX_WIDTH = 10;
    private Grid grid;
    public Path path = new Path(new Coordinnate(0, 0));
    private Direction direction = Direction.NORTH;

    public Rover(Grid grid) {
        this.grid = grid;
    }

    public String execute(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'R')
                direction = moveRight();
            if (c == 'L')
                direction = moveLeft();
            if (c == 'M') {
                path = this.grid.nextCoordinateFor(path, direction);
            }
        }
        String obstacleString = "O:";
        StringBuilder stringBuilder = new StringBuilder();
        if (path.isObstacles())
            stringBuilder.append(obstacleString);
        return stringBuilder
                .append(path.currentCoordinnate.x)
                .append(":")
                .append(path.currentCoordinnate.y)
                .append(":")
                .append(direction.value)
                .toString();
    }

    private Direction moveLeft() {
        return direction.moveLeft();
    }

    private Direction moveRight() {
        return direction.moveRight();
    }

}
