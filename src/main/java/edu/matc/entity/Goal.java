package edu.matc.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Represents a goal entity
 *
 * @author kmiller
 */
@Entity
@Table(name = "goal")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    @Column(name = "goal_type")
    private String goalType;

    @Column(name = "target")
    private double target;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * No argument constructor
     */
    public Goal() {

    }

    /**
     * Creates a new goal for a user
     * @param goalType goal type
     * @param target target goal
     * @param startDate start date
     * @param endDate end date
     */
    public Goal(String goalType, double target, LocalDate startDate, LocalDate endDate) {

        this.goalType = goalType;
        this.target = target;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Getter for id
     * @return goal ID
     */
    public int getId() {

        return id;
    }

    /**
     *  Setter for ID
     * @param id goal id
     */
    public void setId(int id) {

        this.id = id;
    }

    /**
     * Getter for goal type
     * @return goal type
     */
    public String getGoalType() {

        return goalType;
    }

    /**
     * Setter for goal type
     * @param goalType type of goal
     */
    public void setGoalType(String goalType) {

        this.goalType = goalType;

    }

    /**
     * Getter for target goal
     * @return target goal
     */
    public double getTarget() {

        return target;

    }

    /**
     * Setter for goal targer
     * @param target for the goal
     */
    public void setTarget(double target) {

        this.target = target;
    }

    /**
     * Getter for start date
     * @return start date for the goal
     */
    public LocalDate getStartDate() {

        return startDate;
    }

    /**
     * Setter for start date
     * @param startDate start date for the goal
     */
    public void setStartDate(LocalDate startDate) {

        this.startDate = startDate;

    }

    /**
     * Getter for end date
     * @return end date for the goal
     */
    public LocalDate getEndDate() {

        return endDate;
    }

    /**
     * setter for goal end date
     * @param endDate for goal
     */
    public void setEndDate(LocalDate endDate) {

        this.endDate = endDate;
    }

    /**
     * Getter for user
     * @return user
     */
    public User getUser() {

        return user;
    }

    /**
     * Sets the user
     * @param user user
     */
    public void setUser(User user) {

        this.user = user;
    }

    /**
     * Calculates the total distance run during the goal's date range
     *
     * @param runs user's runs
     * @return total distance toward the goal
     */
    public double calculateProgress(List<Run> runs) {

        double totalDistance = 0;

        for (Run run : runs) {
            LocalDate runDate = run.getRunDate();

            if (!runDate.isBefore(startDate) && !runDate.isAfter(endDate)) {
                totalDistance += run.getDistance();
            }
        }

        return totalDistance;
    }

    /**
     * Calculates the percentage completed toward this goal.
     *
     * @param progress total distance completed
     * @return the goal completion percentage
     */
    public double calculatePercentage(double progress) {

        if (target <= 0) {
            return 0;
        }

        double percentage = (progress / target) * 100;

        return Math.round(percentage * 10) / 10.0;
    }

    /**
     * Compares this goal to another object
     * @param o object to compare
     * @return true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goal goal = (Goal) o;

        return id == goal.id
                && Double.compare(goal.target, target) == 0
                && Objects.equals(goalType, goal.goalType)
                && Objects.equals(startDate, goal.startDate)
                && Objects.equals(endDate, goal.endDate);
    }

    /**
     * Generates a hash code for the goal
     * @return hash code
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, goalType, target, startDate, endDate);
    }
}
