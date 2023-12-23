package com.basis.cadastro.repository;

import com.basis.cadastro.model.WeightStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeightStatsRepository
        extends JpaRepository<WeightStats, Long> {
}
