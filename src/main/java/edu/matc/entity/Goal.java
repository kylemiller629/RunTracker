package edu.matc.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                && startDate.equals(goal.startDate)
                && endDate.equals(goal.endDate)
                && goalType.equals(goal.goalType);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, goalType, target, startDate, endDate);
    }
}
