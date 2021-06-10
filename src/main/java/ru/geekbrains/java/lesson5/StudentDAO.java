package ru.geekbrains.java.lesson5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDAO {
    private static SessionFactory factory = SessionFactoryCreator.getSessionFactory();

    public static Student findById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student product = session.get(Student.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public static List<Student> findAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> allProducts = session.createQuery("select p from Student p").getResultList();
            session.getTransaction().commit();
            return allProducts;
        }
    }

    public static void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student product = session.get(Student.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public static Student saveOrUpdate(Student product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }
}
