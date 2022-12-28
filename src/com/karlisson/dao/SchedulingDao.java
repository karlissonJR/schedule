package com.karlisson.dao;

import java.time.LocalDate;
import java.util.List;

import com.karlisson.model.Scheduling;

public interface SchedulingDao {
    
    List<Scheduling> findBySchedulingDay(Integer dayId);
    void insert(Scheduling obj);

}
