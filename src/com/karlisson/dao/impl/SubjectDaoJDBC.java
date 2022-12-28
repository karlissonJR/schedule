package com.karlisson.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.karlisson.dao.SubjectDao;
import com.karlisson.dbconnection.MysqlConnection;
import com.karlisson.model.Subject;

public class SubjectDaoJDBC implements SubjectDao {

    public final Connection connection;

    public SubjectDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Subject> findAll() {

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM subjects");
            resultSet = statement.executeQuery();

            List<Subject> subjects = new ArrayList<>();

            while (resultSet.next()) {
                Subject subject = new Subject();

                subject.setId(resultSet.getInt("id"));
                subject.setName(resultSet.getString("name"));

                subjects.add(subject);
            }

            return subjects;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlConnection.closeStatement(statement);
            MysqlConnection.closeResultSet(resultSet);
        }

        return new ArrayList<>();
    }

    @Override
    public Subject findById(Integer id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            statement = connection.prepareStatement("SELECT * FROM subjects WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Subject subject = new Subject();

                subject.setId(resultSet.getInt("id"));
                subject.setName(resultSet.getString("name"));

                return subject;
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
    public void insert(Subject obj) {

        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("INSERT INTO subjects (name) VALUES (?)");
            statement.setString(1, obj.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlConnection.closeStatement(statement);
        }

    }

    @Override
    public void update(Subject obj) {

        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("UPDATE subjects SET name = ? WHERE id = ?");
            statement.setString(1, obj.getName());
            statement.setInt(2, obj.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlConnection.closeStatement(statement);
        }
    }
    
}
