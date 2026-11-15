
package edu.matc.persistence;

import edu.matc.entity.Run;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunTest {

    /**
     * Tests calculating the average pace per mile
     */
    @Test
    void calculatePace() {

        Run run = new Run(
                LocalDate.of(2026, 11, 15),
                3.0,
                30,
                "Morning run"
        );

        String actual = run.getPace();

        assertEquals("10:00", actual);
    }

    /**
     * Tests calculating pace with an invalid distance
     */
    @Test
    void calculatePaceWithZeroDistance() {

        Run run = new Run(
                LocalDate.of(2026, 11, 15),
                0.0,
                30,
                "Morning run"
        );

        String actual = run.getPace();

        assertEquals("N/A", actual);
    }
}
