package com.campus.workshop.controller;


import com.campus.workshop.dto.WorkshopRequest;
import com.campus.workshop.dto.WorkshopResponse;
import com.campus.workshop.service.WorkshopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workshops")
public class WorkshopController {

    private final WorkshopService workshopService;

    // Constructor injection
    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @GetMapping
    public ResponseEntity<List<WorkshopResponse>> getAllWorkshops(
            @RequestParam(required = false) String category) {
        List<WorkshopResponse> workshops = workshopService.getAllWorkshops(category);
        return ResponseEntity.ok(workshops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkshopResponse> getWorkshopById(@PathVariable Long id) {
        Optional<WorkshopResponse> workshop = workshopService.getWorkshopById(id);
        return workshop.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<WorkshopResponse> createWorkshop(@RequestBody WorkshopRequest request) {
        WorkshopResponse created = workshopService.createWorkshop(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkshopResponse> updateWorkshop(
            @PathVariable Long id, @RequestBody WorkshopRequest request) {
        Optional<WorkshopResponse> updated = workshopService.updateWorkshop(id, request);
        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkshop(@PathVariable Long id) {
        boolean deleted = workshopService.deleteWorkshop(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}