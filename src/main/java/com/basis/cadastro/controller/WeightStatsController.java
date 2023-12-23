package com.basis.cadastro.controller;

import com.basis.cadastro.model.User;
import com.basis.cadastro.model.WeightStats;
import com.basis.cadastro.service.UserService;
import com.basis.cadastro.service.WeightStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Component
@RequestMapping(value = "weight-stats")
public class WeightStatsController {

    @Autowired
    public WeightStatsService weightStatsService;

    @PostMapping("/save")
    public WeightStats save(@RequestBody WeightStats weightStats)
            throws Exception {
        System.out.println("============================");
        System.out.println(weightStats);
        System.out.println("============================");
        return weightStatsService.save(weightStats);
    }
}
