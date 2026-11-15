package com.campus.workshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "workshop")
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 40)
    private String category;

    @Column(nullable = false, length = 100)
    private String presenter;

    @Column(name = "duration_minutes", nullable = false)
    private int durationMinutes;

    @Column(nullable = false)
    private int capacity;

    // Required no-argument constructor
    public Workshop() {}

    public Workshop(String title, String category, String presenter, int durationMinutes, int capacity) {
        this.title = title;
        this.category = category;
        this.presenter = presenter;
        this.durationMinutes = durationMinutes;
        this.capacity = capacity;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getPresenter() { return presenter; }
    public void setPresenter(String presenter) { this.presenter = presenter; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}