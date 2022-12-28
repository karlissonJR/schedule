package com.karlisson.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.karlisson.model.Subject;
import com.karlisson.services.SubjectService;

public class MainServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        SubjectService subjectService = new SubjectService();
        
        List<Subject> subjects = subjectService.findAll();
        getServletContext().setAttribute("subjects", subjects);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/main.jsp");
        dispatcher.forward(request, response);
    }

}
