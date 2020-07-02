package lenoytishka.dao;

import lenoytishka.entity.Student;

public class StudentDaoImpl extends StudentDao {



    public static class Builder {
        private String name;
        private boolean mark;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMark(boolean mark) {
            this.mark = mark;
            return this;
        }

        public Student built() {
            Student student = new Student();
            student.setMark(mark);
            student.setName(name);
            return student;
        }
    }
}
