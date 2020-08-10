package org.github.com.jefesimpson.javalin.an.example;

import java.sql.SQLException;
import java.util.List;

public interface StudentGroupCrud {
    public List<StudentGroup> getStudentClass() throws SQLException;
    public StudentGroup getStudentClassById(int id) throws SQLException;
    public void deleteStudentClass(StudentGroup deleteStudentClass) throws SQLException;
    public void createStudentClass(StudentGroup createStudentClass) throws SQLException;
    public void updateStudentClass(StudentGroup updateStudentClass) throws SQLException;
}
