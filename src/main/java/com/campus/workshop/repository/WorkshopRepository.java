package com.campus.workshop.repository;
import com.campus.workshop.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {

    // Order all by ID ascending as required
    List<Workshop> findAllByOrderByIdAsc();

    // Case-insensitive category filter ordered by ID ascending
    List<Workshop> findByCategoryIgnoreCaseOrderByIdAsc(String category);
}