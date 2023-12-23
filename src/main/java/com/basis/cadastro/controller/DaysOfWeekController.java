package com.basis.cadastro.controller;

import com.basis.cadastro.model.DaysOfWeek;
import com.basis.cadastro.model.User;
import com.basis.cadastro.service.DaysOfWeekService;
import com.basis.cadastro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping(value = "days-of-week")
public class DaysOfWeekController {

    @Autowired
    public DaysOfWeekService daysOfWeekService;

    @GetMapping("/get-all")
    public List<DaysOfWeek> findAll() {
        List<DaysOfWeek> d = daysOfWeekService.findAll();
        System.out.println(d);
        return d;
    }
}