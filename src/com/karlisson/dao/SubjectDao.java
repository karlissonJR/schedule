package com.karlisson.dao;

import java.util.List;

import com.karlisson.model.Subject;

public interface SubjectDao {
    
    List<Subject> findAll();
    Subject findById(Integer id);
    void insert(Subject obj);
    void update(Subject obj);

}
