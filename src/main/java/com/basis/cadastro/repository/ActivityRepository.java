package com.basis.cadastro.repository;

import com.basis.cadastro.model.DaysOfWeek;
import com.basis.cadastro.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository
        extends JpaRepository<Activity, Long> {
}
