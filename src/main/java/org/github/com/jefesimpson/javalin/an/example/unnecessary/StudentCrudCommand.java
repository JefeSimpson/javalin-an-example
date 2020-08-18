package org.github.com.jefesimpson.javalin.an.example.unnecessary;

import org.github.com.jefesimpson.javalin.an.example.tables.Student;

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
    public void deleteStudent(int id) throws SQLException {
        dao().deleteById(id);
    }

    @Override
    public void postStudent(Student createStudent) throws SQLException {
        dao().create(createStudent);
    }

    @Override
    public void patchStudent(Student updateStudent) throws SQLException {
        dao().update(updateStudent);
    }
}
