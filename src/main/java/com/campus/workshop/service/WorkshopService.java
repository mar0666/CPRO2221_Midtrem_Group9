package com.campus.workshop.service;

import com.campus.workshop.dto.WorkshopRequest;
import com.campus.workshop.dto.WorkshopResponse;
import com.campus.workshop.entity.Workshop;
import com.campus.workshop.repository.WorkshopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkshopService {

    private final WorkshopRepository workshopRepository;

    // Constructor injection
    public WorkshopService(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }

    public List<WorkshopResponse> getAllWorkshops(String category) {
        List<Workshop> workshops;
        if (category != null && !category.isEmpty()) {
            workshops = workshopRepository.findByCategoryIgnoreCaseOrderByIdAsc(category);
        } else {
            workshops = workshopRepository.findAllByOrderByIdAsc();
        }
        return workshops.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public Optional<WorkshopResponse> getWorkshopById(Long id) {
        return workshopRepository.findById(id).map(this::mapToResponse);
    }

    public WorkshopResponse createWorkshop(WorkshopRequest request) {
        Workshop workshop = new Workshop(
                request.title(),
                request.category(),
                request.presenter(),
                request.durationMinutes(),
                request.capacity()
        );
        Workshop saved = workshopRepository.save(workshop);
        return mapToResponse(saved);
    }

    public Optional<WorkshopResponse> updateWorkshop(Long id, WorkshopRequest request) {
        Optional<Workshop> optionalWorkshop = workshopRepository.findById(id);
        if (optionalWorkshop.isPresent()) {
            Workshop workshop = optionalWorkshop.get();
            workshop.setTitle(request.title());
            workshop.setCategory(request.category());
            workshop.setPresenter(request.presenter());
            workshop.setDurationMinutes(request.durationMinutes());
            workshop.setCapacity(request.capacity());
            Workshop updated = workshopRepository.save(workshop);
            return Optional.of(mapToResponse(updated));
        }
        return Optional.empty();
    }

    public boolean deleteWorkshop(Long id) {
        if (workshopRepository.existsById(id)) {
            workshopRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private WorkshopResponse mapToResponse(Workshop workshop) {
        return new WorkshopResponse(
                workshop.getId(),
                workshop.getTitle(),
                workshop.getCategory(),
                workshop.getPresenter(),
                workshop.getDurationMinutes(),
                workshop.getCapacity()
        );
    }
}