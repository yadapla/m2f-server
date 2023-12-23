package com.basis.cadastro.repository;

import com.basis.cadastro.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepository
        extends JpaRepository<Availability, Long> {

    List<Availability> findAllByUserId(Long userId);

    List<Availability> findAllByUserIdAndDayOfWeekId(Long userId, Long dayOfWeekId);

    void deleteByUserIdAndDayOfWeekId(Long userId, Long dayOfWeekId);

    void deleteById(Long id);
}
