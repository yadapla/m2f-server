package com.basis.cadastro.controller;

import com.basis.cadastro.model.Availability;
import com.basis.cadastro.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping(value = "availability")
public class AvailabilityController {

    @Autowired
    public AvailabilityService availabilityService;

    @GetMapping("/get-all-by-user/{userId}")
    public List<Availability> findAllByUserId(@PathVariable Long userId) {
        List<Availability> r = availabilityService.findAllByUserId(userId);
        return r;
    }

    @GetMapping("/get-all-by-user-and-day/{userId}/{dayOfWeek}")
    public List<Availability> findAllByUserIdAndDayOfWeek(@RequestParam Long userId, @RequestParam Long dayOfWeek) {
        List<Availability> r = availabilityService.findAllByUserIdAndDayOfWeekId(userId, dayOfWeek);
        return r;
    }

    @PostMapping("/save")
    public Availability save(@RequestBody Availability availability) {
        Availability newAvailability = availabilityService.save(availability);
        return newAvailability;
    }

    @DeleteMapping("/delete/{userId}/{daysOfWeek}")
    public void delete(@PathVariable Long userId, @PathVariable Long daysOfWeek) {
        availabilityService.delete(userId, daysOfWeek);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteByIs(@PathVariable Long id) {
        availabilityService.deleteById(id);
    }
}