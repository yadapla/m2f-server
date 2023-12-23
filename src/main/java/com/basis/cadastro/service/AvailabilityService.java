package com.basis.cadastro.service;

import com.basis.cadastro.model.Activity;
import com.basis.cadastro.model.Availability;
import com.basis.cadastro.repository.ActivityRepository;
import com.basis.cadastro.repository.AvailabilityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvailabilityService {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public List<Availability> findAllByUserId(Long userId) {
        List<Availability> list = availabilityRepository.findAllByUserId(userId);
        return list;
    }

    public List<Availability> findAllByUserIdAndDayOfWeekId(Long userId, Long dayOfWeekId) {
        List<Availability> list = availabilityRepository.findAllByUserIdAndDayOfWeekId(userId, dayOfWeekId);
        return list;
    }

    public Availability save(Availability availability) {
        return availabilityRepository.save(availability);
    }

    @Transactional
    public void delete(Long userId, Long daysOfWeek) {
        availabilityRepository.deleteByUserIdAndDayOfWeekId(userId, daysOfWeek);
    }

    public void deleteById(Long id) {
        availabilityRepository.deleteById(id);
    }
}
