package org.github.com.jefesimpson.javalin.an.example;

import java.sql.SQLException;
import java.util.List;

public class StudentGroupCrudCommand implements StudentGroupConnection {

    @Override
    public List<StudentGroup> getStudentClass() throws SQLException {
        return dao().queryForAll();
    }

    @Override
    public StudentGroup getStudentClassById(int id) throws SQLException {
        return dao().queryForId(id);
    }

    @Override
    public void deleteStudentClass(StudentGroup deleteStudentClass) throws SQLException {
        dao().delete(deleteStudentClass);
    }

    @Override
    public void createStudentClass(StudentGroup createStudentClass) throws SQLException {
        dao().create(createStudentClass);
    }

    @Override
    public void updateStudentClass(StudentGroup updateStudentClass) throws SQLException {
        dao().update(updateStudentClass);
    }
}
