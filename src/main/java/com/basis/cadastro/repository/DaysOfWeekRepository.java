package com.basis.cadastro.repository;

import com.basis.cadastro.model.DaysOfWeek;
import com.basis.cadastro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaysOfWeekRepository
        extends JpaRepository<DaysOfWeek, Long> {
}
