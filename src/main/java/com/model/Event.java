package com.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events", schema = "postgres")
public class Event {

    @Id
    @GeneratedValue(generator = GenerationType.IDENTITY);
    private Long id;

    private String name;

    @JoinColumn(name = "created");
    private LocalDateTime created;
    @JoinColumn(name = "updated");
    private LocalDateTime updated;
}
