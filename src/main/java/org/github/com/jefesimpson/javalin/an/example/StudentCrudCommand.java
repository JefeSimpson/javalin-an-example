package org.github.com.jefesimpson.javalin.an.example;

import java.sql.SQLException;
import java.util.List;

public class StudentCrudCommand implements StudentConnection {

    @Override
    public List<Student> getStudent() throws SQLException {
        return dao().queryForAll();
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        return dao().queryForId(id);
    }

    @Override
    public void deleteStudent(Student deleteStudent) throws SQLException {
        dao().delete(deleteStudent);
    }

    @Override
    public void createStudent(Student createStudent) throws SQLException {
        dao().create(createStudent);
    }

    @Override
    public void updateStudent(Student updateStudent) throws SQLException {
        dao().update(updateStudent);
    }
}
