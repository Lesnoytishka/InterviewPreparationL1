package lenoytishka;

import lenoytishka.dao.StudentDaoImpl;
import lenoytishka.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();

        studentDao.saveStudents(createThousendStudents());

        System.out.println(studentDao.findAll());

        studentDao.deleteAllStudents();

        System.out.println(studentDao.findAll());
    }

    private static List<Student> createThousendStudents() {
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 1000; i++) {
            students.add(new StudentDaoImpl.Builder()
                    .setName("name-" + i)
                    .setMark(i % 3 == 0)
                    .built()
            );
        }
        return students;
    }
}
