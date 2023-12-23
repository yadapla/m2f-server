package com.basis.cadastro.controller;

import com.basis.cadastro.model.Activity;
import com.basis.cadastro.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping(value = "activities")
public class ActivityController {

    @Autowired
    public ActivityService activityService;

    @GetMapping("/get-all")
    public List<Activity> findAll() {
        List<Activity> r = activityService.findAll();
        return r;
    }
}