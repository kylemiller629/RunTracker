package edu.matc.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user of MileMarker
 *
 * @author kmiller
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Run> runs = new ArrayList<>();

    /**
     * No argument constructor
     */
    public User() {

    }

    /**
     * Creates a new user
     * @param firstName user's first name
     * @param lastName user's last name
     * @param userName user's username
     */
    public User(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    /**
     * Getter for ID
     * @return user's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for ID
     * @param id user id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for user's first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for first name
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for last name
     * @return user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for last name
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for username
     * @return user's username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for username
     * @param userName username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter for user runs
     * @return runs
     */
    public List<Run> getRuns() {
        return runs;
    }

    /**
     * Setter for user runs
     * @param runs runs
     */
    public void setRuns(List<Run> runs) {
        this.runs = runs;
    }
}
