package com.karlisson.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.karlisson.dto.DaySchedulingDto;
import com.karlisson.dto.SchedulingDto;
import com.karlisson.model.DayScheduling;
import com.karlisson.model.Scheduling;
import com.karlisson.services.DaySchedulingService;
import com.karlisson.services.SchedulingService;
import com.karlisson.utils.Util;

public class DaySchedulingServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LocalDate day = Util.toDate(request.getParameter("day_scheduling"));

        DaySchedulingService service = new DaySchedulingService();
        SchedulingService schedulingService = new SchedulingService();

        HttpSession session = request.getSession();
        session.setAttribute("day", day);
        
        DayScheduling dayScheduling = service.findByDayScheduling(day);
        List<Scheduling> schedulings = schedulingService.findBySchedulingDay(dayScheduling.getId());
        List<SchedulingDto> schedulingsDto = schedulings.stream()
            .map(scheduling -> {

                DaySchedulingDto daySchedulingDto = new DaySchedulingDto(dayScheduling.getId(), dayScheduling.getDate().toString());

                return new SchedulingDto(
                    scheduling.getId(),
                    scheduling.getHourStart().toString(),
                    scheduling.getHourEnd().toString(),
                    daySchedulingDto,
                    scheduling.getSubject()
                );
            }).collect(Collectors.toList());

        try {
            String json = new Gson().toJson(schedulingsDto);
        
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(json);
        } catch (Exception e) {
            System.out.println("ERROR = " + e.getMessage());
        }
        
    }
    
}
