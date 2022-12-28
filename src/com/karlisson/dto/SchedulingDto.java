package com.karlisson.dto;

import com.karlisson.model.DayScheduling;
import com.karlisson.model.Subject;

public class SchedulingDto {
    
    private Integer id;
    private String hourStart;
    private String hourEnd;
    private DaySchedulingDto dayScheduling;
    private Subject subject;
    
    public SchedulingDto(Integer id, String hourStart, String hourEnd, DaySchedulingDto dayScheduling, Subject subject) {
        this.id = id;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
        this.dayScheduling = dayScheduling;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public DaySchedulingDto getDayScheduling() {
        return dayScheduling;
    }

    public void setDayScheduling(DaySchedulingDto dayScheduling) {
        this.dayScheduling = dayScheduling;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    

}
