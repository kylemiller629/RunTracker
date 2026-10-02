package edu.matc.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
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
     * @param id goal id
     * @param goalType goal type
     * @param target target goal
     * @param startDate start date
     * @param endDate end date
     * @param user user
     */
    public Goal(int id, String goalType, double target, LocalDate startDate, LocalDate endDate, User user) {
        this.id = id;
        this.goalType = goalType;
        this.target = target;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
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
}
