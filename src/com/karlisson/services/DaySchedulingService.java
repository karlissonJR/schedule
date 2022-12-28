package com.karlisson.services;

import java.time.LocalDate;

import com.karlisson.dao.DaoFactory;
import com.karlisson.dao.DaySchedulingDao;
import com.karlisson.model.DayScheduling;

public class DaySchedulingService {

    private DaySchedulingDao dao = DaoFactory.createDaySchedulingDao();

    public DayScheduling findById(Integer id) {
        return dao.findById(id);
    }

    public DayScheduling findByDayScheduling(LocalDate date) {

        DayScheduling dayScheduling = dao.findByDayScheduling(date);

        if (dayScheduling == null) {
            dayScheduling = new DayScheduling();
            dayScheduling.setDate(date);
            insert(dayScheduling);
            dayScheduling = findByDayScheduling(date);
        }

        return dayScheduling;
    }

    public void insert(DayScheduling obj) {
        dao.insert(obj);
    }
    
}
