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

    /**
     * No argument constructor
     */
    public Run() {

    }

    /**
     * Creates a new run
     * @param runDate date of run
     * @param distance distance of run
     * @param duration duration of run
     * @param notes notes about the run
     */
    public Run(LocalDate runDate, double distance, double duration, String notes) {
        this.runDate = runDate;
        this.distance = distance;
        this.duration = duration;
        this.notes = notes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "run_date")
    private LocalDate runDate;

    @Column(name = "distance")
    private double distance;

    @Column(name = "duration")
    private double duration;

    @Column(name = "notes")
    private String notes;

    /**
     * Getter for run duration
     * @return run duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Setter for run duration
     * @param duration duration of run
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Getter for notes
     * @return run notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Setter for run notes
     * @param notes run notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

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
