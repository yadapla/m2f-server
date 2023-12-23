package com.basis.cadastro.repository;

import com.basis.cadastro.model.MyActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyActivitiesRepository
        extends JpaRepository<MyActivities, Long> {
    List<MyActivities> findAllByUserId(Long id);
    void deleteByUserId(Long userId);
    void deleteByUserIdAndActivityId(Long userId, Long activityId);
}
