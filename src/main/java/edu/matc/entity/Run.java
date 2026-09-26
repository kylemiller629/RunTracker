package edu.matc.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Represents a run logged by a user
 * @author kmiller
 */
@Entity
@Table(name = "run")
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "run_date")
    private LocalDate runDate;

    @Column(name = "distance")
    private double distance;

    /**
     * Getter for ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for ID
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for date of run
     * @return date of run
     */
    public LocalDate getRunDate() {
        return runDate;
    }

    /**
     * Setter for run date
     * @param runDate date of run
     */
    public void setRunDate(LocalDate runDate) {
        this.runDate = runDate;
    }

    /**
     *Getter for distance
     * @return run distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Setter for distance
     * @param distance run distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * toString method
     * @return a string
     */
    @Override
    public String toString() {
        return "Run{" +
                "id=" + id +
                ", runDate=" + runDate +
                ", distance=" + distance +
                '}';
    }
}
