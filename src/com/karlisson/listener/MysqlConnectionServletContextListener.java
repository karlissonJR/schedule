package com.karlisson.listener;

import java.io.InputStream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.karlisson.dbconnection.MysqlConnection;

public class MysqlConnectionServletContextListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        InputStream stream = event.getServletContext().getResourceAsStream("db.properties");
        MysqlConnection.getConnection(stream);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        MysqlConnection.closeConnection();
    }

}
