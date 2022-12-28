package com.karlisson.dao;

import java.time.LocalDate;

import com.karlisson.model.DayScheduling;

public interface DaySchedulingDao {
    
    DayScheduling findById(Integer id);
    DayScheduling findByDayScheduling(LocalDate date);
    void insert(DayScheduling obj);

}
