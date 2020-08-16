package org.github.com.jefesimpson.javalin.an.example.tutor;

import org.github.com.jefesimpson.javalin.an.example.student.Student;

import java.sql.SQLException;
import java.util.List;

public interface TutorCrud {
    List<Tutor> getTutor() throws SQLException;
    Tutor getTutorById(int id) throws SQLException;
    void deleteTutor(int id) throws SQLException;
    void postTutor(Tutor createTutor) throws SQLException;
    void patchTutor(Tutor updateTutor) throws SQLException;
}
