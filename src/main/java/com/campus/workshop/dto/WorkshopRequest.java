package com.campus.workshop.dto;

public record WorkshopRequest(
        String title,
        String category,
        String presenter,
        int durationMinutes,
        int capacity
) {}