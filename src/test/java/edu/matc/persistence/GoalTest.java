package edu.matc.persistence;

import edu.matc.entity.Goal;
import edu.matc.entity.Run;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoalTest {

    /**
     * Tests calculating the total distance toward a goal
     */
    @Test
    void calculateProgress() {

        Goal goal = new Goal("Weekly Distance", 15.0, LocalDate.of(2026, 10, 12), LocalDate.of(2026, 10, 18));

        Run run1 = new Run();
        run1.setRunDate(LocalDate.of(2026, 10, 13));
        run1.setDistance(5.0);

        Run run2 = new Run();
        run2.setRunDate(LocalDate.of(2026, 10, 14));
        run2.setDistance(3.0);

        List<Run> runs = new ArrayList<>();
        runs.add(run1);
        runs.add(run2);

        double actual = goal.calculateProgress(runs);

        assertEquals(8.0, actual, 0.001);
    }

    /**
     * Tests calculating the percentage complete toward a goal
     */
    @Test
    void calculatePercentage() {
        Goal goal = new Goal("Weekly Distance", 20.0, LocalDate.of(2026, 10, 12), LocalDate.of(2026, 10, 18));

        Run run1 = new Run();
        run1.setRunDate(LocalDate.of(2026, 10, 13));
        run1.setDistance(5.0);

        Run run2 = new Run();
        run2.setRunDate(LocalDate.of(2026, 10, 14));
        run2.setDistance(5.0);

        List<Run> runs = new ArrayList<>();
        runs.add(run1);
        runs.add(run2);

        double progress = goal.calculateProgress(runs);
        double actual = goal.calculatePercentage(progress);

        assertEquals(50.0, actual, 0.001);
    }
}
