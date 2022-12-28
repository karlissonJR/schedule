package com.karlisson.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.karlisson.dao.SchedulingDao;
import com.karlisson.dbconnection.MysqlConnection;
import com.karlisson.model.DayScheduling;
import com.karlisson.model.Scheduling;
import com.karlisson.model.Subject;
import com.karlisson.services.DaySchedulingService;
import com.karlisson.services.SubjectService;

public class SchedulingDaoJDBC implements SchedulingDao{

    private Connection connection;

    public SchedulingDaoJDBC(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<Scheduling> findBySchedulingDay(Integer dayId) {

        DaySchedulingService daySchedulingService = new DaySchedulingService();
        SubjectService subjectService = new SubjectService();
        
        List<Scheduling> schedulings = new ArrayList<>();

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            statement = connection.prepareStatement("SELECT * FROM scheduling WHERE day_scheduling_id = ? ORDER BY hour_start");
            statement.setInt(1, dayId);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Scheduling scheduling = new Scheduling();
                
                scheduling.setId(resultSet.getInt("id"));
                scheduling.setHourStart(resultSet.getTimestamp("hour_start").toLocalDateTime());
                scheduling.setHourEnd(resultSet.getTimestamp("hour_end").toLocalDateTime());
                
                int daySchedulingId = resultSet.getInt("day_scheduling_id");
                DayScheduling dayScheduling = daySchedulingService.findById(daySchedulingId);
                scheduling.setDayScheduling(dayScheduling);

                int subjectId = resultSet.getInt("subjects_id");
                Subject subject = subjectService.findById(subjectId);
                scheduling.setSubject(subject);

                schedulings.add(scheduling);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlConnection.closeStatement(statement);
            MysqlConnection.closeResultSet(resultSet);
        }

        return schedulings;
    }

    @Override
    public void insert(Scheduling obj) {
        
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("INSERT INTO scheduling (hour_start,hour_end,day_scheduling_id,subjects_id) VALUES (?,?,?,?)");
            
            statement.setTimestamp(1, Timestamp.valueOf(obj.getHourStart()));
            statement.setTimestamp(2, Timestamp.valueOf(obj.getHourEnd()));
            statement.setInt(3, obj.getDayScheduling().getId());
            statement.setInt(4, obj.getSubject().getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlConnection.closeStatement(statement);
        }
        
    }
    
}
