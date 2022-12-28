package com.karlisson.dao;

import com.karlisson.dao.impl.DaySchedulingDaoJDBC;
import com.karlisson.dao.impl.SchedulingDaoJDBC;
import com.karlisson.dao.impl.SubjectDaoJDBC;
import com.karlisson.dbconnection.MysqlConnection;

public class DaoFactory {
    
    private DaoFactory() {}

    public static SubjectDao createSubjectDao() {
        return new SubjectDaoJDBC(MysqlConnection.getConnection());
    }

    public static DaySchedulingDao createDaySchedulingDao() {
        return new DaySchedulingDaoJDBC(MysqlConnection.getConnection());
    }

    public static SchedulingDao createSchedulingDao() {
        return new SchedulingDaoJDBC(MysqlConnection.getConnection());
    }

}
