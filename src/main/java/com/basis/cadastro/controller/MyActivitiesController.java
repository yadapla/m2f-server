package com.basis.cadastro.controller;

import com.basis.cadastro.model.Activity;
import com.basis.cadastro.model.MyActivities;
import com.basis.cadastro.service.ActivityService;
import com.basis.cadastro.service.MyActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Component
@RequestMapping(value = "my-activities")
public class MyActivitiesController {

    @Autowired
    public MyActivitiesService myActivitiesService;

    @GetMapping("/get-all/{id}")
    public List<MyActivities> findAll(@PathVariable Long id) {
        List<MyActivities> list = myActivitiesService.findAllByUserId(id);
        return list;
    }

    @PostMapping("/save")
    public List<MyActivities> save(@RequestBody List<MyActivities> list) {
        if (list.isEmpty()) {
            return null;
        }

        Long userId = list.stream().findFirst().get().getUserId();
        myActivitiesService.deleteByUserId(userId);
        var newList = myActivitiesService.saveAll(list);
        return newList;
    }

    @PostMapping("/add")
    public MyActivities add(@RequestBody MyActivities item) {
        return myActivitiesService.add(item);
    }

    @DeleteMapping("/remove/{userId}/{activityId}")
    public boolean remove(@PathVariable Long userId, @PathVariable Long activityId) {
        return myActivitiesService.remove(userId, activityId);
    }
}