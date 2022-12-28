package com.karlisson.services;

import java.util.List;

import com.karlisson.dao.DaoFactory;
import com.karlisson.dao.SubjectDao;
import com.karlisson.model.Subject;

public class SubjectService {
    
    private SubjectDao dao = DaoFactory.createSubjectDao();

    public List<Subject> findAll() {
        return dao.findAll();
    }

    public Subject findById(Integer id) {
        return dao.findById(id);
    }

    public void insert(Subject obj) {
        dao.insert(obj);
    }

    public void update(Subject obj) {
        dao.update(obj);
    }

}
