package com.karlisson.services;

import java.util.List;

import com.karlisson.dao.DaoFactory;
import com.karlisson.dao.SchedulingDao;
import com.karlisson.model.Scheduling;

public class SchedulingService {
    
    private SchedulingDao dao = DaoFactory.createSchedulingDao();

    public List<Scheduling> findBySchedulingDay(Integer dayId) {
        return dao.findBySchedulingDay(dayId);
    }

    public void insert(Scheduling obj) {
        dao.insert(obj);
    }

}
