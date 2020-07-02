package lenoytishka.dao;

import lenoytishka.HibernateSessionFactoryCreator;
import lenoytishka.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {
    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;
    List<Student> students;

    public StudentDao() {
        this.sessionFactory = HibernateSessionFactoryCreator.getSessionFactory();
    }

    private void openSession() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    private void closeSession() {
        transaction.commit();
        session.close();
    }

    public void saveStudent(Student student) {
        openSession();
        try {
            session.save(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession();
        }
    }

    public void saveStudents(List<Student> students) {
        openSession();
        try {
            for (Student student : students) {
                session.save(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession();
        }
    }

    public List<Student> findAll() {
        openSession();
        try {
            students = session.createQuery("from Student").list();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            closeSession();
        }
        return students;
    }

    public Student findStudent(long id) {
        Student student = null;
        openSession();
        try {
            student = session.get(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession();
        }
        return student;
    }

    public void updateStudent(Student student) {
        openSession();
        try {
            session.saveOrUpdate(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession();
        }
    }

    public void deleteStudent(Student student) {
        openSession();
        try {
            session.delete(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession();
        }
    }

    public void deleteStudent(long id) {
        openSession();
        try {
            Student student = findStudent(id);
            session.delete(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession();
        }
    }

    public void deleteAllStudents() {
        openSession();
        try {
            session.createQuery("delete from Student").executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession();
        }
    }
}
