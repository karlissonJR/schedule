package com.karlisson.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.karlisson.dao.DaySchedulingDao;
import com.karlisson.dbconnection.MysqlConnection;
import com.karlisson.model.DayScheduling;

public class DaySchedulingDaoJDBC implements DaySchedulingDao {
    
    Connection connection;

    public DaySchedulingDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public DayScheduling findById(Integer id) {
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            statement = connection.prepareStatement("SELECT * FROM day_scheduling WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DayScheduling dayScheduling = new DayScheduling();
                dayScheduling.setId(resultSet.getInt("id"));
                dayScheduling.setDate(resultSet.getDate("day_scheduling").toLocalDate());

                return dayScheduling;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlConnection.closeStatement(statement);
            MysqlConnection.closeResultSet(resultSet);
        }

        return null;

    }

    @Override
    public DayScheduling findByDayScheduling(LocalDate date) {
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            statement = connection.prepareStatement("SELECT * FROM day_scheduling WHERE day_scheduling = ?");
            statement.setDate(1, Date.valueOf(date));
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                DayScheduling dayScheduling = new DayScheduling();
                dayScheduling.setId(resultSet.getInt("id"));
                dayScheduling.setDate(resultSet.getDate("day_scheduling").toLocalDate());

                return dayScheduling;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlConnection.closeStatement(statement);
            MysqlConnection.closeResultSet(resultSet);
        }

        return null;

    }

    @Override
    public void insert(DayScheduling obj) {
        
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO day_scheduling (day_scheduling) VALUES (?)");
            statement.setDate(1, Date.valueOf(obj.getDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlConnection.closeStatement(statement);
        }
        
    }

    

}
