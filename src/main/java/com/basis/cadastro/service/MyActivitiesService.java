package com.basis.cadastro.service;

import com.basis.cadastro.model.Activity;
import com.basis.cadastro.model.MyActivities;
import com.basis.cadastro.repository.ActivityRepository;
import com.basis.cadastro.repository.MyActivitiesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MyActivitiesService {
    @Autowired
    private MyActivitiesRepository myActivitiesRepository;

    public List<MyActivities> findAllByUserId(Long id) {
        List<MyActivities> list = myActivitiesRepository.findAllByUserId(id);
        return list;
    }

    public List<MyActivities> saveAll(List<MyActivities> list) {
        List<MyActivities> newList = myActivitiesRepository.saveAll(list);
        return newList;
    }

    public MyActivities add(MyActivities item) {
        return myActivitiesRepository.save(item);
    }

    @Transactional
    public boolean remove(Long userId, Long activityId) {
        myActivitiesRepository.deleteByUserIdAndActivityId(userId, activityId);
        return true;
    }

    @Transactional
    public void deleteByUserId(Long userId) {
        myActivitiesRepository.deleteByUserId(userId);
    }
}
