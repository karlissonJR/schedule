package com.karlisson.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ScheduleSessionCounterListener implements HttpSessionListener {

    private static int activeSessions;
    
    @Override
    public synchronized void sessionCreated(HttpSessionEvent event) {
        activeSessions++;
        System.out.println("SESSOES ATIVAS = " + activeSessions);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent event) {
        activeSessions--;
        System.out.println("SESSOES ATIVAS = " + activeSessions);
    }
}
