package be.craftmine.kata.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoverTest {

    private Rover rover;

    @BeforeEach
    void beforeEach() {
        rover = new Rover(new Grid());
    }

    @ParameterizedTest
    @CsvSource({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N",
    })
    void rotate_right(String commands, String positions) {
        //Give
        rover = new Rover(new Grid());

        //When
        String position = rover.execute(commands);

        //Then
        assertThat(position).isEqualTo(positions);
    }

    @ParameterizedTest
    @CsvSource({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N",
    })
    void rotate_left(String commands, String positions) {
        //Give
        rover = new Rover(new Grid());

        //When
        String position = rover.execute(commands);

        //Then
        assertThat(position).isEqualTo(positions);
    }

    @ParameterizedTest
    @CsvSource({
            "M, 0:1:N",
            "MMM, 0:3:N",
    })
    void move_up(String commands, String positions) {
        //Give
        rover = new Rover(new Grid());

        //When
        String position = rover.execute(commands);

        //Then
        assertThat(position).isEqualTo(positions);
    }

    @ParameterizedTest
    @CsvSource({
            "MMMMMMMMMM, 0:0:N",
            "MMMMMMMMMMMMMMM, 0:5:N",
    })
    void wraap_from_top_to_bottom_when_moving_north(String commands, String positions) {
        //Give
        rover = new Rover(new Grid());

        //When
        String position = rover.execute(commands);

        //Then
        assertThat(position).isEqualTo(positions);
    }

    @ParameterizedTest
    @CsvSource({
            "RM, 1:0:E",
            "RMMMMM, 5:0:E",
    })
    void move_right(String commands, String positions) {
        //Give
        rover = new Rover(new Grid());

        //When
        String position = rover.execute(commands);

        //Then
        assertThat(position).isEqualTo(positions);
    }

    @ParameterizedTest
    @CsvSource({
            "RMMMMMMMMMM, 0:0:E",
            "RMMMMMMMMMMMMMMM, 5:0:E",
    })
    void wraap_from_right_to_left_when_moving_east(String commands, String positions) {
        //Give
        rover = new Rover(new Grid());

        //When
        String position = rover.execute(commands);

        //Then
        assertThat(position).isEqualTo(positions);
    }

    @ParameterizedTest
    @CsvSource({
            "LM, 9:0:W",
            "LLMMMMM, 0:5:S",
    })
    void move_left(String commands, String positions) {
        //Give
        rover = new Rover(new Grid());

        //When
        String position = rover.execute(commands);

        //Then
        assertThat(position).isEqualTo(positions);
    }

    @ParameterizedTest
    @CsvSource({
            "MMMM, O:0:3:N",
            "RMMMMM, O:1:0:E",
    })
    void stop_at_obstacle(String commands, String positions) {
        //Give
        Coordinnate obstacle_0x4 = new Coordinnate(0, 4);
        Coordinnate obstacle_2x0 = new Coordinnate(2, 0);

        Grid grid = new Grid(List.of(obstacle_0x4, obstacle_2x0));

        rover = new Rover(grid);

        //When
        String position = rover.execute(commands);

        //Then
        assertThat(position).isEqualTo(positions);
    }



}