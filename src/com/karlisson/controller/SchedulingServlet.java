package com.karlisson.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.karlisson.model.DayScheduling;
import com.karlisson.model.Scheduling;
import com.karlisson.model.Subject;
import com.karlisson.services.DaySchedulingService;
import com.karlisson.services.SchedulingService;
import com.karlisson.services.SubjectService;
import com.karlisson.utils.Util;

public class SchedulingServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String hourStart = request.getParameter("hour_start");
        String hourEnd = request.getParameter("hour_end");
        String day = request.getParameter("day_scheduling"); 
        String subjectId = request.getParameter("subject");

        SchedulingService schedulingService = new SchedulingService();

        DaySchedulingService daySchedulingService = new DaySchedulingService();
        DayScheduling dayScheduling = daySchedulingService.findByDayScheduling(Util.toDate(day));

        SubjectService subjectService = new SubjectService();
        Subject subject = subjectService.findById(Integer.parseInt(subjectId));

        Scheduling scheduling = new Scheduling();
        scheduling.setHourStart(Util.toDateTime(day, hourStart));
        scheduling.setHourEnd(Util.toDateTime(day, hourEnd));
        scheduling.setDayScheduling(dayScheduling);
        scheduling.setSubject(subject);

        schedulingService.insert(scheduling);

        response.sendRedirect("day_scheduling?day_scheduling=" + day);
    }
    
}
