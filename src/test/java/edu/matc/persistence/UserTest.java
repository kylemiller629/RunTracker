package edu.matc.persistence;
import edu.matc.entity.Run;
import edu.matc.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {


    /**
     * Tests calculating the total distance of a user's run
     */
    @Test
    void calculateTotalDistance() {
        User user = new User("Test", "User", "testUser");

        Run run1 = new Run();
        run1.setDistance(5.0);

        Run run2 = new Run();
        run2.setDistance(3.1);

        Run run3 = new Run();
        run3.setDistance(6.0);

        user.addRun(run1);
        user.addRun(run2);
        user.addRun(run3);

        double actual = user.calculateTotalDistance();
        assertEquals(14.1, actual, 0.001);
    }
}
