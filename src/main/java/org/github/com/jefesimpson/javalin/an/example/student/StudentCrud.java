package org.github.com.jefesimpson.javalin.an.example.student;

import org.github.com.jefesimpson.javalin.an.example.student.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentCrud {
    List<Student> getStudent() throws SQLException;
    Student getStudentById(int id) throws SQLException;
    void deleteStudent(int id) throws SQLException;
    void postStudent(Student createStudent) throws SQLException;
    void patchStudent(Student updateStudent) throws SQLException;
}
