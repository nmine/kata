package be.craftmine.kata.rover;

import lombok.Getter;

@Getter
public class Path {

    private final Coordinnate startingCoordinnate;
    public Coordinnate currentCoordinnate;
    private boolean obstacles;

    public Path(Coordinnate startingCoordinnate) {
        this.currentCoordinnate = new Coordinnate(0, 0);
        this.startingCoordinnate = startingCoordinnate;
    }

    void setCurrentCoordonate(Coordinnate coordinnate, boolean isObstacle) {
        this.currentCoordinnate = coordinnate;
        this.obstacles = isObstacle;
    }
}
