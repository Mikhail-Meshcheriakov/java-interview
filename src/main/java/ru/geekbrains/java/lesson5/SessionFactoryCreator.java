package ru.geekbrains.java.lesson5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryCreator {
    public static SessionFactory getSessionFactory() {
        SessionFactory factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
        return factory;
    }
}
