package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class Util {
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
    private static final String userName = "root";
    private static final String password = "root";

//    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName(Driver);
//            connection = DriverManager.getConnection(url, userName, password);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(jm.task.core.jdbc.model.User.class);
            configuration.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty(Environment.URL, url);
            configuration.setProperty(Environment.USER, userName);
            configuration.setProperty(Environment.PASS, password);
            configuration.setProperty(Environment.HBM2DDL_AUTO, "create-drop");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}







