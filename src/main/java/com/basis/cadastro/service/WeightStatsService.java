package com.basis.cadastro.service;

import com.basis.cadastro.model.DaysOfWeek;
import com.basis.cadastro.model.Activity;
import com.basis.cadastro.model.WeightStats;
import com.basis.cadastro.repository.ActivityRepository;
import com.basis.cadastro.repository.DaysOfWeekRepository;
import com.basis.cadastro.repository.UserRepository;
import com.basis.cadastro.repository.WeightStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeightStatsService {
    @Autowired
    private WeightStatsRepository weightStatsRepository;

    public WeightStats save(WeightStats weightStats ) {
        return weightStatsRepository.save(weightStats);
    }
}
