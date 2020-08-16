package org.github.com.jefesimpson.javalin.an.example.tutorstudent;

import org.github.com.jefesimpson.javalin.an.example.tutor.Tutor;

import java.sql.SQLException;
import java.util.List;

public interface TutorStudentCrud {
    List<TutorStudent> getTutorStudent() throws SQLException;
    TutorStudent getTutorStudentById(int id) throws SQLException;
    void deleteTutorStudent(int id) throws SQLException;
    void postTutorStudent(TutorStudent createTutorStudent) throws SQLException;
    void patchTutorStudent(TutorStudent updateTutorStudent) throws SQLException;
}
