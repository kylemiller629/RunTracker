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

}
