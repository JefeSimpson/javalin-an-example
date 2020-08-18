package org.github.com.jefesimpson.javalin.an.example.unnecessary;

import org.github.com.jefesimpson.javalin.an.example.tables.StudentGroup;

import java.sql.SQLException;
import java.util.List;

public class StudentGroupCrudCommand implements StudentGroupConnection {

    @Override
    public List<StudentGroup> getStudentGroup() throws SQLException {
        return dao().queryForAll();
    }

    @Override
    public StudentGroup getStudentGroupById(int id) throws SQLException {
        return dao().queryForId(id);
    }

    @Override
    public void deleteStudentGroup(int id) throws SQLException {
        dao().deleteById(id);
    }

    @Override
    public void postStudentGroup(StudentGroup createStudentClass) throws SQLException {
        dao().create(createStudentClass);
    }

    @Override
    public void patchStudentGroup(StudentGroup updateStudentClass) throws SQLException {
        dao().update(updateStudentClass);
    }
}
