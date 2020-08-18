package org.github.com.jefesimpson.javalin.an.example.unnecessary;

import org.github.com.jefesimpson.javalin.an.example.tables.StudentGroup;

import java.sql.SQLException;
import java.util.List;

public interface StudentGroupCrud {
    public List<StudentGroup> getStudentGroup() throws SQLException;
    public StudentGroup getStudentGroupById(int id) throws SQLException;
    public void deleteStudentGroup(int id) throws SQLException;
    public void postStudentGroup(StudentGroup createStudentClass) throws SQLException;
    public void patchStudentGroup(StudentGroup updateStudentClass) throws SQLException;
}
