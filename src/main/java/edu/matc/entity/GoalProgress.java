package edu.matc.entity;

/**
 * Represents a goal and its calculated progress.
 *
 * @author kmiller
 */
public class GoalProgress {

    private Goal goal;
    private double progress;
    private double percentage;

    /**
     * No args constructor
     */
    public GoalProgress() {

    }

    /**
     * Creates goal progress information
     *
     * @param goal running goal
     * @param progress progress miles completed toward the goal
     */
    public GoalProgress(Goal goal, double progress) {
        this.goal = goal;
        this.progress = progress;
        this.percentage = goal.calculatePercentage(progress);
    }

    /**
     * Getter for goal
     * @return goal
     */
    public Goal getGoal() {
        return goal;
    }

    /**
     * Getter for progress
     * @return progress
     */
    public double getProgress() {
        return progress;
    }

    /**
     * Getter to get percentage
     * @return percentage
     */
    public double getPercentage() {
        return percentage;
    }
}
