package com.campus.workshop.dto;

public record WorkshopResponse(
        Long id,
        String title,
        String category,
        String presenter,
        int durationMinutes,
        int capacity
) {}