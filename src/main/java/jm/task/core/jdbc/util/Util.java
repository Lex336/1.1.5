package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.USER;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/kata";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aA5771521";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try{
                Properties setting = new Properties();
                setting.put(Environment.URL, URL);
                setting.put(Environment.USER, USERNAME);
                setting.put(Environment.PASS, PASSWORD);
                setting.put(Environment.DIALECT, "org.hibernate.dialect.MyAQLDialect");
                setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                setting.put(Environment.HBM2DDL_AUTO, "create-drop");

                Configuration configuration = new Configuration();
                configuration.setProperties(setting);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  sessionFactory;
    }

    public static Connection createConnection(){
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot create connection.", e);
        }
    }
}
