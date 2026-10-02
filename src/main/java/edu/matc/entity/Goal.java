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
}
