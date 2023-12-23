package com.basis.cadastro.service;

import com.basis.cadastro.model.DaysOfWeek;
import com.basis.cadastro.model.User;
import com.basis.cadastro.repository.DaysOfWeekRepository;
import com.basis.cadastro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DaysOfWeekService {
    @Autowired
    private DaysOfWeekRepository daysOfWeekRepository;

    public List<DaysOfWeek> findAll() {
        List<DaysOfWeek> daysOfWeek = daysOfWeekRepository.findAll();
        return daysOfWeek;
    }
}
