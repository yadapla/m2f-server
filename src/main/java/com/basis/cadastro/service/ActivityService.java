package com.basis.cadastro.service;

import com.basis.cadastro.model.Activity;
import com.basis.cadastro.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> findAll() {
        List<Activity> activities = activityRepository.findAll();
        return activities;
    }
}
