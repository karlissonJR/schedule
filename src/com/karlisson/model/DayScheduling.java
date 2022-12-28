package com.karlisson.model;

import java.time.LocalDate;

public class DayScheduling {

    private Integer id;
    private LocalDate date;
    
    public DayScheduling() {}

    public DayScheduling(Integer id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    
}
