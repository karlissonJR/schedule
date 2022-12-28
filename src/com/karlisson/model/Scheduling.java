package com.karlisson.model;

import java.time.LocalDateTime;

public class Scheduling {
    
    private Integer id;
    private LocalDateTime hourStart;
    private LocalDateTime hourEnd;
    private DayScheduling dayScheduling;
    private Subject subject;

    public Scheduling() {}

    public Scheduling(Integer id, LocalDateTime hourStart, LocalDateTime hourEnd, DayScheduling dayScheduling,
            Subject subject) {
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

    public LocalDateTime getHourStart() {
        return hourStart;
    }

    public void setHourStart(LocalDateTime hourStart) {
        this.hourStart = hourStart;
    }

    public LocalDateTime getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(LocalDateTime hourEnd) {
        this.hourEnd = hourEnd;
    }

    public DayScheduling getDayScheduling() {
        return dayScheduling;
    }

    public void setDayScheduling(DayScheduling dayScheduling) {
        this.dayScheduling = dayScheduling;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    
}
