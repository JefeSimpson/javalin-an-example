package org.github.com.jefesimpson.javalin.an.example;

import java.sql.SQLException;
import java.util.List;

public interface StudentCrud {
    List<Student> getStudent() throws SQLException;
    Student getStudentById(int id) throws SQLException;
    void deleteStudent(Student deleteStudent) throws SQLException;
    void createStudent(Student createStudent) throws SQLException;
    void updateStudent(Student updateStudent) throws SQLException;
}
